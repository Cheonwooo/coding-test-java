package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2806 {
	private static int n, answer;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			answer = 0;
			for (int i = 0; i < n; i++) {
				boolean[][] visited = new boolean[n][n];
				dfs(visited, 0);
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(boolean[][] visited, int depth) {
		if (depth == n) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) count++;
				}
			}
			if (count == n) answer++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[depth][i]) {
				visited[depth][i] = true;
				for (int j = 0; j < 8; j++) {
					int cx = depth;
					int cy = i;
					
					while (true) {
						int nx = cx + dx[j];
						int ny = cy + dy[j];
						
						if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
						
						visited[nx][ny] = true;
						cx = nx;
						cy = ny;
					}
				}
				dfs(visited, depth+1);
			}
		}
	}

}
