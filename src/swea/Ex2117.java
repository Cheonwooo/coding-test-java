package swea.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 : 87,658kb	시간 : 329ms

public class Solution_2117_모의_홈_방범_서비스_천현우 {
	
	private static int n, m, answer;
	private static int[] dx = {-1, 0, 1 ,0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					start(i, j);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void start(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[n][n];
		visited[x][y] = true;
		q.add(new int[] {x, y});
		
		int homeCount = 0;
		if (map[x][y] == 1) homeCount++;
		for (int i = 1; i <= n+1; i++) {
			if (i != 1) {
				homeCount += bfs(q);
			}
			if (homeCount <= 0) continue;
			calculateServiceHome(homeCount, i);
		}
	}
	
	public static int bfs(Queue<int[]> q) {
		int size = q.size();
		int count = 0;
		for (int i = 0; i < size; i++) {
			int[] p = q.poll();
			
			for (int j = 0; j < 4; j++) {
				int nx = p[0] + dx[j];
				int ny = p[1] + dy[j];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				if (map[nx][ny] == 1) count++;
				q.add(new int[] {nx, ny});
			}
		}
		return count;
	}
	
	public static void calculateServiceHome(int homeCount, int k) {
		int homePrice = homeCount * m;
		int servicePrice = (int)Math.pow(k, 2) + (int)Math.pow(k-1, 2);
		
		if (homePrice - servicePrice>= 0) {
			answer = Math.max(answer, homeCount);
		}
	}
}
