package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14500_2 {
	private static int max, n, m;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(1, map[i][j], i, j);
				dfs2(i, j);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	
	public static void dfs(int depth, int sum, int x, int y) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(depth+1, sum + map[nx][ny], nx, ny);
			visited[nx][ny] = false;
		}
	}
	
	public static void dfs2(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int sum = map[x][y];
			for (int j = 0; j < 3; j++) {
				int nx = x + dx[(i+j)%4];
				int ny = y + dy[(i+j)%4];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
				
				sum += map[nx][ny];
			}
			max = Math.max(max, sum);
		}
	}
}
