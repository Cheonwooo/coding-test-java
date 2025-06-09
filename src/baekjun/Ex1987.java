package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1987 {
	
	private static int n, m, max = 0;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[] route;
	private static boolean[][] visited;
	private static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		visited = new boolean[n][m];
		route = new boolean[26];
		dfs(0, 0, 1);
		System.out.println(max);
	}
	
	private static void dfs(int startX, int startY, int count) {
		visited[startX][startY] = true;
		route[map[startX][startY] - 'A'] = true;
		max = Math.max(max, count);
		
		for (int i = 0; i < 4; i++) {
			int nx = startX + dx[i];
			int ny = startY + dy[i];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (!visited[nx][ny] && !route[map[nx][ny] - 'A']) {
				visited[nx][ny] = true;
				route[map[nx][ny] - 'A'] = true;
				count += 1;
				dfs(nx, ny, count);
				visited[nx][ny] = false;
				route[map[nx][ny] - 'A'] = false;
				count -= 1;
			}
		}
	}
}
