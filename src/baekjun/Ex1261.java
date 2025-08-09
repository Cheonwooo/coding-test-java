package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1261 {
	
	private static int n, m;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j].charAt(0)-'0';
			}
		}
		
		dfs(0, 0);
	}
	
	private static void dfs(int x, int y) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[2] - o2[2];
		});
		
		boolean[][] visited = new boolean[n][m];
		pq.offer(new int[] {x, y, 0});
		visited[x][y] = true;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			int cost = cur[2];
			
			if (cx == n-1 && cy == m-1) {
				System.out.println(cost);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				if (map[nx][ny] == 1) {
					pq.offer(new int[] {nx, ny, cost+1});
				} else {
					pq.offer(new int[] {nx, ny, cost});
				}
			}
		}
	}
}
