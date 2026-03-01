package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex27737 {
	
	private static int n, m, k, count = 0;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][n];
		int requiredSpore = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0 && !visited[i][j]) {
					count = 1;
					bfs(i, j);
					requiredSpore += count / k;
					if (count % k != 0) {
						requiredSpore++;
					}
				}
			}
		}
		
		if (requiredSpore == 0) {
			System.out.println("IMPOSSIBLE");
		} else {
			if (requiredSpore > m) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println("POSSIBLE");
				System.out.println(m - requiredSpore);
			}
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.add(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || arr[nx][ny] == 1) continue;
				visited[nx][ny] = true;
				count++;
				q.add(new int[] {nx, ny});
			}
		}
	}

}
