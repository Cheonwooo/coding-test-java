package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4485 {
	
	private static int n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr, temp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int index = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			temp = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(temp[i], Integer.MAX_VALUE);
			}
			
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			temp[0][0] = arr[0][0];
			int rupee = bfs(0, 0, arr[0][0]);
			
			sb.append("Problem " + (index++) + ": " + rupee + "\n");
		}
		System.out.println(sb);
	}
	
	private static int bfs(int x, int y, int rupee) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, rupee});
		
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			int cost = cur[2];
			
			if (cost > min) continue;
			
			if (cx == n-1 && cy == n-1) {
				min = Math.min(min, cost);
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (temp[nx][ny] > arr[nx][ny] + temp[cx][cy]) {
					temp[nx][ny] = arr[nx][ny] + temp[cx][cy];
					q.offer(new int[] {nx, ny, temp[nx][ny]});
				}
			}
		}
		return min;
	}
}
