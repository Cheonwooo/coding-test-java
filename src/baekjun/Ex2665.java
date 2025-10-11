package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Ex2665 {
	
	private static int n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr, dist;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		dist = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(findMaze(0, 0));
	}
	
	private static int findMaze(int x, int y) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.offer(new int[] {x, y, 0});
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			
			if (now[0] == n-1 && now[1] == n-1) {
				return now[2];
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				if (arr[nx][ny] == 1) {
					pq.offer(new int[] {nx, ny, now[2]});
				} else {
					pq.offer(new int[] {nx, ny, now[2] + 1});
				}
			}
		}
		return 0;
	}
}
