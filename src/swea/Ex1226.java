package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex1226 {
	
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int T = Integer.parseInt(br.readLine());
			
			map = new int[16][16];
			visited = new boolean[16][16];
			
			int startX = 0;
			int startY = 0;
			int endX = 0;
			int endY = 0;
			for (int i = 0; i < 16; i++) {
				String number = br.readLine();
				
				for (int j = 0; j < 16; j++) {
					map[i][j] = (int)number.charAt(j)-'0';
					
					if (map[i][j] == 1) {
						visited[i][j] = true;
					} else if (map[i][j] == 2) {
						startX = i;
						startY = j;
					} else if (map[i][j] == 3) {
						endX = i;
						endY = j;
					}
				}
			}
			
			bfs(startX, startY);
			
			if (visited[endX][endY]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			
			int cx = pair.x;
			int cy = pair.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16 || visited[nx][ny]) {
					continue;
				}
				
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}

}
