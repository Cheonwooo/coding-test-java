package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4963 {
	
	private static int n, m, flag;
	private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static int[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) break;
			
			arr = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			flag = 2;
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {
						visited[i][j] = true;
						bfs(i, j);
						flag++;
					}
				}
			}
			sb.append((flag - 2)).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		arr[x][y] = flag;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			int cx = now[0];
			int cy = now[1];
			
			for (int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
				if (arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					arr[nx][ny] = flag;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}

}
