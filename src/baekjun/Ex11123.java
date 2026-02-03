package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex11123 {
	
	private static int n, m;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static char[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int count = 0;
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == '#' && !visited[i][j]) {
						checkSheepFlock(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
	
	private static void checkSheepFlock(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
						visited[nx][ny] || map[nx][ny] == '.') continue;
				
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}

}
