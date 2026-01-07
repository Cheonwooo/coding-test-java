package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16948 {
	
	private static int n, sx, sy, ex, ey;
	private static int[] dx = {-2, -2, 0, 0, 2, 2};
	private static int[] dy = {-1, 1, -2, 2, -1, 1};
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		
		move();
		
		if (map[ex][ey] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(map[ex][ey]);
		}
	}
	
	private static void move() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		q.offer(new int[] {sx, sy});
		visited[sx][sy] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 6; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				map[nx][ny] = map[cx][cy] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
