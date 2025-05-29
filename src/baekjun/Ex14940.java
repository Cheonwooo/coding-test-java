package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14940 {
	
	private static int n, m, x, y;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map, dist;

	public static void main(String[] args) throws IOException{
		inputValues();
		bfs();
		printAnswer();
	}
	
	private static void inputValues() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		
		x = 0;
		y = 0;
		makeMap(br);
	}
	
	private static void makeMap(BufferedReader br) throws IOException {
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				dist[i][j] = 10000001;
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					x = i;
					y = j;
					dist[i][j] = 0;
				} else if (map[i][j] == 0) {
					dist[i][j] = -1;
				}
			}
		}
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
				if (dist[cx][cy] != -1) {
					dist[nx][ny] = Math.min(dist[nx][ny], dist[cx][cy] + 1);
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	private static void printAnswer() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dist[i][j] == -1) sb.append(0 + " ");
				else if (dist[i][j] == 10000001) sb.append(-1 + " ");
				else sb.append(dist[i][j] + " "); 
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
