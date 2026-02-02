package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1303 {
	
	private static int n, m;
	private static int powerWhite, powerBlue;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] visited;
	private static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) bfs(i,j);
			}
		}
		
		System.out.println(powerWhite + " " + powerBlue);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new int[] {x, y});
		
		int power = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
				if (map[nx][ny] == map[cx][cy]) {
					visited[nx][ny] = true;
					power++;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		
		if (map[x][y] == 'W') {
			powerWhite += Math.pow(power, 2);
		} else {
			powerBlue += Math.pow(power, 2);
		}
	}
}
