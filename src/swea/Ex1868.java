package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex1868 {
	
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n;
	private static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	private static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	private static int[][] bombMap;
	private static String[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			n = Integer.parseInt(br.readLine());
			map = new String[n][n];
			bombMap = new int[n][n];
			visited = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				String[] bomb = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = bomb[j];
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					makeBombMap(i, j);
				}
			}
			
			int answer = 0;
			for (int i = 0 ; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (bombMap[i][j] == 0 && !visited[i][j]) {
						answer++;
						bfs(i, j);
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!map[i][j].equals("T") && !map[i][j].equals("*")) {
						answer++;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void makeBombMap(int x, int y) {
		
		if (map[x][y].equals(".")) {
			int bombCount = 0;
			
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (map[nx][ny].equals("*")) bombCount++;
			}
			
			bombMap[x][y] = bombCount;
		} else {
			bombMap[x][y] = -1;
		}
		
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		visited[x][y] = true;
		map[x][y] = "T";
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int cx = pair.x;
			int cy = pair.y;
			
			for (int i = 0; i < 8; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				
				if (bombMap[nx][ny] == -1) continue;
				
				if (bombMap[nx][ny] == 0) {
					q.add(new Pair(nx, ny));
				}
				map[nx][ny] = "T";
				visited[nx][ny] = true;
			}
		}
	}
}
