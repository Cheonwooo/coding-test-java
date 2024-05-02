package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex1249 {
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int INF = (int) 1e9;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] visited;
	private static int[][] arr, map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			visited = new boolean[n][n];
			arr = new int[n][n];
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = (int)s.charAt(j)-'0';
				}
			}
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(map[i], INF);
			}
			map[0][0] = 0;
			
			int min = bfs(0, 0, n);
			
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int bfs(int x, int y, int n) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			
			x = pair.x;
			y = pair.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				
				if (map[nx][ny] > map[x][y] + arr[nx][ny]) {
					map[nx][ny] = map[x][y] + arr[nx][ny];
					q.add(new Pair(nx, ny));
				}
			}
		}
		
		return map[n-1][n-1];
	}

}
