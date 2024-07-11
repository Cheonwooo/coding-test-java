package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex17144 {
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int r, c;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map, tempMap;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		List<Pair> list = new ArrayList<>();
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {
					list.add(new Pair(i, j));
				}
			}
		}
		
		while (t-- > 0) {
			tempMap = new int[r][c];
			checkDust();
			addDust();
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			moveDust(list);
		}
		int answer = calculateDustAmount();
		System.out.println(answer);
	}
	
	public static void checkDust() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != 0) {
					spreadDust(i, j);
				}
			}
		}
	}
	
	public static void spreadDust(int x, int y) {
		int subDustAmount = 0;
		int spreadDustAmount = map[x][y] / 5;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == -1) continue;
			tempMap[nx][ny] += spreadDustAmount;
			subDustAmount += spreadDustAmount;
		}
		map[x][y] -= subDustAmount;
	}

	public static void addDust() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] += tempMap[i][j];
			}
		}
	}
	
	public static void moveDust(List<Pair> list) {
		Pair reverseDust = list.get(0);
		Pair forwardDust = list.get(1);
		
		moveReverse(reverseDust.x, reverseDust.y);
		moveForward(forwardDust.x, forwardDust.y);
	}
	
	public static void moveReverse(int x, int y) {
		int cx = x;
		int cy = y;
		
		while (--cx >= 0) {
			map[cx+1][cy] = map[cx][cy];
		}
		cx++;
		
		while (++cy < c) {
			map[cx][cy-1] = map[cx][cy];
		}
		cy--;
		
		while (++cx <= x) {
			map[cx-1][cy] = map[cx][cy];
		}
		cx--;
		
		while (--cy >= 1) {
			map[cx][cy+1] = map[cx][cy];
		}
		
		map[cx][cy+1] = 0;
		map[x][y] = -1;
	}
	
	public static void moveForward(int x, int y) {
		int cx = x;
		int cy = y;
		
		while (++cx < r) {
			map[cx-1][cy] = map[cx][cy];
		}
		cx--;
		
		while (++cy < c) {
			map[cx][cy-1] = map[cx][cy];
		}
		cy--;
		
		while (--cx >= x) {
			map[cx+1][cy] = map[cx][cy];
		}
		cx++;
		
		while (--cy >= 1) {
			map[cx][cy+1] = map[cx][cy];
		}
		
		map[cx][cy+1] = 0;
		map[x][y] = -1;
		
	}
	
	public static int calculateDustAmount() {
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}
		return sum;
	}
}
