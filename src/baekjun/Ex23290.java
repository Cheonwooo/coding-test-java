package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 54408kb, 시간 252ms

public class Ex23290 {
	
	private static class Shark implements Comparable<Shark> {
		int count;
		String dir;

		public Shark(int count, String dir) {
			this.count = count;
			this.dir = dir;
		}
		
		public int compareTo(Shark o) {
			if (this.count == o.count) {
				return this.dir.compareTo(o.dir);
			}
			return o.count - this.count;
		}

		@Override
		public String toString() {
			return "Shark [count=" + count + ", dir=" + dir + "]";
		}
		
	}
	
	private static int sx, sy;
	private static int[] temp;
	private static int[] fdx = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[] fdy = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] sdx = {-1, 0, 1, 0};
	private static int[] sdy = {0, -1, 0, 1};
	private static int[][] smell, tempSmell;
	private static boolean[][] visited;
	private static List<int[]> directions = new ArrayList<>();
	private static PriorityQueue<Shark> pq;;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer>[][] fish = new List[4][4];
		initFishMap(fish);
		temp = new int[3];
		makeDirection(0);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken())-1;
			int fy = Integer.parseInt(st.nextToken())-1;
			int fd = Integer.parseInt(st.nextToken())-1;
			
			fish[fx][fy].add(fd);
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		
		smell = new int[4][4];
		for (int i = 0; i < s; i++) {
			List<Integer>[][] tempFish = new List[4][4];
			initFishMap(tempFish);
			
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					moveFish(fish, tempFish, j, k);
				}
			}
			moveShark(fish, tempFish);
		}
		
		int answer = countFishCount(fish);
		System.out.println(answer);
	}
	
	private static void initFishMap(List<Integer>[][] map) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
	}
	
	private static void makeDirection(int depth) {
		if (depth == 3) {
			directions.add(new int[] {temp[0], temp[1], temp[2]});
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			temp[depth] = i;
			makeDirection(depth+1);
		}
	}
	
	private static void moveFish(List<Integer>[][] fish, List<Integer>[][] tempFish, int x, int y) {
		for (int i = 0; i < fish[x][y].size(); i++) {
			move(tempFish, x, y, fish[x][y].get(i));
		}
	}
	
	private static void move(List<Integer>[][] tempFish, int x, int y, int startD) {
		boolean isMove = false;
//		System.out.println(x + " " + y + " " + startD);
		for (int i = 0; i < 8; i++) {
			int nx = x + fdx[(startD - i + 8) % 8];
			int ny = y + fdy[(startD - i + 8) % 8];
//			System.out.println("next " + nx + " " + ny + " " + (startD - i + 8) % 8);
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			if (smell[nx][ny] != 0 || (sx == nx && sy == ny)) continue;
//			System.out.println("move " + nx + " " + ny + " " + (startD - i + 8) % 8);
			tempFish[nx][ny].add((startD - i + 8) % 8);
			isMove = true;
			break;
		}
		if (!isMove) tempFish[x][y].add(startD);
	}
	
	private static void moveShark(List<Integer>[][] fish, List<Integer>[][] tempFish) {
		visited = new boolean[4][4];
//		System.out.println("shark " + sx + " " + sy);
		pq = new PriorityQueue<>();
		findSharkDestination(sx, sy, tempFish);
		
		tempSmell = new int[4][4];
		moveSharkNext(tempFish);
		discountSmellCount(fish, tempFish);
	}
	
	private static void findSharkDestination(int x, int y, List<Integer>[][] tempFish) {
		for (int i = 0; i < directions.size(); i++) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			visited = new boolean[4][4];
			int[] nextDir = directions.get(i);
			
			int cx = sx;
			int cy = sy;
//			System.out.println(Arrays.toString(nextDir));
			for (int j = 0; j < nextDir.length; j++) {
				int nx = cx + sdx[nextDir[j]];
				int ny = cy + sdy[nextDir[j]];
//				System.out.println(nx + " " + ny);
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
				if (!visited[nx][ny]) {
					count += tempFish[nx][ny].size();
				}
				sb.append(nextDir[j]);
				visited[nx][ny] = true;
				cx = nx;
				cy = ny;
			}
			
			if (sb.length() == 3) {
				pq.offer(new Shark(count, sb.toString()));
			}
		}
	}
	
	private static void moveSharkNext(List<Integer>[][] tempFish) {
		Shark next = pq.poll();
//		System.out.println(next);
		for (int i = 0; i < 3; i++) {
			int d = next.dir.charAt(i) - '0';
			int nx = sx + sdx[d];
			int ny = sy + sdy[d];
			
			if (tempFish[nx][ny].size() != 0) {
				tempFish[nx][ny] = new ArrayList<>();
				tempSmell[nx][ny] = 2;
			}

			sx = nx;
			sy = ny;
		}
	}
	
	private static void discountSmellCount(List<Integer>[][] fish, List<Integer>[][] tempFish) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (smell[i][j] != 0) {
					smell[i][j]--;
				}
				
				if (tempSmell[i][j] != 0) {
					smell[i][j] = tempSmell[i][j];
				}
				
				fish[i][j].addAll(tempFish[i][j]);
			}
		}
	}
	
	private static int countFishCount(List<Integer>[][] fish) { 
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum += fish[i][j].size();
			}
		}
		return sum;
	}
}
