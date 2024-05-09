package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1861 {
	private static int n, roomNumber, max;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	
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

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			roomNumber = 0;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n ; j++) {
					bfs(i, j);
				}
			}
			
			sb.append(roomNumber + " " + max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y, 1));
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			
			int cx = pair.x;
			int cy = pair.y;
			int count = pair.count;
			
			if (max < count) {
				max = count;
				roomNumber = map[x][y];
			} else if (max == count) {
				roomNumber = Math.min(map[x][y], roomNumber);
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != map[cx][cy] + 1) continue;
				
				if (map[nx][ny] == map[cx][cy] + 1) {
					count++;
					q.add(new Pair(nx, ny, count));
				}
			}
		}
	}

}
