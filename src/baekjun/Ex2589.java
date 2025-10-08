package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2589 {
	
	private static int n, m, answer;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr;
	private static boolean[][] visited;
	private static List<int[]> treasure = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				if (input[j].equals("W")) {
					arr[i][j] = 0;
				} else {
					treasure.add(new int[] {i, j});
					arr[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < treasure.size(); i++) {
			visited = new boolean[n][m];
			int[] now = treasure.get(i);
			bfs(now[0], now[1]);
		}
		System.out.println(answer);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, 0});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			int cx = now[0];
			int cy = now[1];
			int cnt = now[2];
			
			answer = Math.max(answer, cnt);
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
						visited[nx][ny] || arr[nx][ny] == 0) continue;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny, cnt + 1});
			}
		}
	}
}
