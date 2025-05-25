package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex21736 {
	
	private static int n, m, answer;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x, y);
		
		if (answer == 0) {
			System.out.println("TT");
		} else {
			System.out.println(answer);
		}
	}
	
	private static void bfs(int x, int y) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 'X') continue;
				if (map[nx][ny] == 'P') answer++;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
