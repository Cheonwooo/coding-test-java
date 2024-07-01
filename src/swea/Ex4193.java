package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4193 {
	public static class Pair {
		int x;
		int y;
		int count;
		
		public Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	private static int n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			bfs(startX, startY);
			
			if (map[endX][endY] == 0) {
				sb.append(-1);
			} else {
				sb.append(map[endX][endY]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y, 1));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int cx = pair.x;
			int cy = pair.y;
			int count = pair.count;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n ||
						visited[nx][ny] || map[nx][ny] == 1) continue;
				
				if (map[nx][ny] == 2) {
					if (count %3 != 0) {
						q.add(new Pair(cx, cy, count+1));
					} else {
						visited[nx][ny] = true;
						map[nx][ny] = count;
						q.add(new Pair(nx, ny, count+1));
					}
				}
				if (map[nx][ny] == 0) {
					visited[nx][ny] = true;
					map[nx][ny] = count;
					q.add(new Pair(nx, ny, count+1));
				}
			}
		}
	}

}
