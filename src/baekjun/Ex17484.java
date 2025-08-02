package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex17484 {
	
	private static int n, m;
	private static int[] dx = {1, 1, 1};
	private static int[] dy = {-1, 0, 1};
	private static int[][] map, answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		answer = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					answer[i][j] = map[i][j];
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			Arrays.fill(answer[n-1], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				dfs(0, i, j, map[0][i]);
			}
		}
		
		int min = 1000;
		for (int i = 0; i < m; i++) {
			min = Math.min(min, answer[n-1][i]);
		}
		System.out.println(min);
	}
	
	private static void dfs(int x, int y, int dir, int sum) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if (ny < 0 || ny >= m) return;
		
		if (nx == n-1) {//끝부분에 도달하면
			answer[nx][ny] = Math.min(answer[nx][ny], sum + map[nx][ny]);
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (dir == i) continue;
			dfs(nx, ny, i, sum + map[nx][ny]);
		}
	}
}
