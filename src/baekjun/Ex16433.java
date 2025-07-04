package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16433 {
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		char[][] map = new char[n][n];
		
		map[r][c] = 'v';
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		q.offer(new int[] {r, c});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					if (map[cx][cy] == 'v') {
						map[nx][ny] = '.';
					} else {
						map[nx][ny] = 'v';
					}
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
