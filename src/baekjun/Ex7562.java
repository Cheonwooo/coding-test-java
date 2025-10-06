package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex7562 {
	
	private static int n;
	private static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	private static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static boolean[][] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			move(sx, sy, ex, ey, 0);
		}
		System.out.println(sb);
	}
	
	private static void move(int sx, int sy, int ex, int ey, int count) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx, sy, 0});
		visited = new boolean[n][n];
		visited[sx][sy] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			int cx = now[0];
			int cy = now[1];
			int cnt = now[2];
			if (cx == ex && cy == ey) {
				sb.append(cnt + "\n");
				return;
			}
			for (int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				visited[nx][ny] =true;
				q.offer(new int[] {nx, ny, cnt+1});
			}
		}
		
	}
}
