package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex13565 {
	
	private static int m, n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (map[0][i] == 0) {
				if (bfs(0, i)) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}
	
	private static boolean bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[nx][ny] == 1) continue;
				if (nx == m-1) {
					return true;
				}
				map[nx][ny] = 1;
				q.offer(new int[] {nx, ny});
			}
		}
		return false;
	}
}
