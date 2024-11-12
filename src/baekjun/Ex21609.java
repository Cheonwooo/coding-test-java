package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex21609 {
	
	private static class Group implements Comparable<Group> {
		int x;
		int y;
		int size;
		int rainbowCount;
		List<int[]> points;

		public Group(int x, int y, int size, int rainbowCount, List<int[]> points) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.rainbowCount = rainbowCount;
			this.points = points;
		}

		public int compareTo(Group o) {
			if (this.size == o.size && this.rainbowCount == o.rainbowCount && this.x == o.x) {
				return o.y - this.y;
			} else if (this.size == o.size && this.rainbowCount == o.rainbowCount) {
				return o.x - this.x;
			} else if (this.size == o.size) {
				return o.rainbowCount - this.rainbowCount;
			}
			return o.size - this.size;
		}

		@Override
		public String toString() {
			return "Group [x=" + x + ", y=" + y + ", size=" + size + ", rainbowCount=" + rainbowCount + ", points="
					+ points + "]";
		}
	}
	
	private static int n, m, answer = 0;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static PriorityQueue<Group> pq;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					map[i][j] = m+1;//무지개 색은 m+1
				}
			}
		}
		
		while (true) {
			//1. bfs로 가장 큰 블록 그룹 찾기(List에 좌표 넣어서 저장)
			//	블록 그룹의 기준 블록은 가장 왼쪽위
			//	블록 크기가 가장 큰 순 -> 무지개 블록 수 많은 순 -> 기분 블록의 행이 가장 큰 -> 열이 가장 큰
			pq = new PriorityQueue<Group>();
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != -1 && map[i][j] != m+1 && map[i][j] != 0) {
						makeIndexMap(visited, i, j);
					}
				}
			}
			
			if (pq.size() == 0) break;
			//2. 해당 그룹 삭제
			removeGroup(pq.poll());
			//3. 모든 칸 아래로 내리기(-1은 제외)
			moveDown();
			//4. 반시계방향 90도 회전
			rotate();
			//5. 모든 칸 아래로 내리기(-1 제외)
			moveDown();
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(answer);
	}

	public static void makeIndexMap(boolean[][] visited, int x, int y) {
		//무지개, 크기, 확인하기
		Queue<int[]> q = new LinkedList<>();
		
		List<int[]> list = new ArrayList<>();
		List<int[]> rainbowList = new ArrayList<>();
		
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		list.add(new int[] {x, y});
		
		int rainbowCount = 0;
		int size = 1;
		int color = map[x][y];
		
		if (map[x][y] == m+1) rainbowCount++;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			int cx = now[0];
			int cy = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				if ((map[nx][ny] == color)) {
					size++;
					visited[nx][ny] = true;
					list.add(new int[] {nx, ny});
					q.offer(new int[] {nx, ny});
				}
				if ((map[nx][ny] == m+1)) {
					size++;
					rainbowCount++;
					visited[nx][ny] = true;
					list.add(new int[] {nx, ny});
					rainbowList.add(new int[] {nx, ny});
					q.offer(new int[] {nx, ny});
				}
			}
		}
		for (int[] p : rainbowList) {
			visited[p[0]][p[1]] = false;
		}
		if (size < 2 || (size == rainbowCount)) return;
		pq.offer(new Group(x, y, size, rainbowCount, list));
	}
	
	private static void removeGroup(Group group) {
		int size = group.size;
		List<int[]> list = group.points;
		
		for (int[] p : list) {
			map[p[0]][p[1]] = 0;
		}
		answer += size*size;
	}
	
	private static void moveDown() {	
		for (int i = 0; i < n; i++) {
			int index = n-1;
			while (true) {//-1, 0이 아닌 값 찾기
				if (index < 0) break;
				if (map[index][i] == 0 || map[index][i] == -1) {
					index--;
					continue;
				}
				
				for (int j = index; j < n-1; j++) {
					if (map[j+1][i] == -1) break;
					if (map[j+1][i] == 0) {
						map[j+1][i] = map[j][i];
						map[j][i] = 0;
					}
				}
				index--;
			}
		}
	}
	
	private static void rotate() {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = map[j][n-1-i];
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.arraycopy(temp[i], 0, map[i], 0, n);
		}
	}

	private static boolean outOfBound(int nx, int ny) {
		return (nx >= 0 && nx < n && ny >= 0 && ny < n);
	}
}
