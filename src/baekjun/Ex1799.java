package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 19612kb, 시간 276ms

public class Ex1799 {

	private static int n, black, white;
	private static int[] dx = {-1, -1, 1, 1};
	private static int[] dy = {-1, 1, 1, -1};
	private static int[][] map, chess;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		chess = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chess[i][j] = (i + j) % 2;
			}
		}
		
		black = 0;
		white = 0;
		
		//black
		dfs(0, 0, 0, 0);
		//white
		dfs(0, 1, 1, 0);
		
		System.out.println(black + white);
	}
	
	public static void dfs(int x, int y, int color, int count) {
		if (x >= n) {
			if (color == 0) {//흑이라면
				black = Math.max(black, count);
			} else {
				white = Math.max(white, count);
			}
			return;
		}
		
		int nx = x;
		int ny = y + 2;
		
		if (ny >= n) {//한 열을 다 돌았으면
			nx++;//다음 행으로 이동
			if (nx < n) {
				if (chess[nx][0] == color) {
					ny = 0;
				} else {
					ny = 1;
				}
			}
		}
		
		if (map[x][y] == 0) {
			dfs(nx, ny, color, count);
			return;
		}
		
		if (isBishop(x, y)) {
			visited[x][y] = true;
			dfs(nx, ny, color, count+1);
			visited[x][y] = false;
		}
		
		dfs(nx, ny, color, count);
	}

	private static boolean isBishop(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			while (true) {
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
				if (visited[nx][ny]) return false;
				
				nx += dx[i];
				ny += dy[i];
			}
		}
		return true;
	}
}
