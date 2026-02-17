package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1113 {
	
	private static int n, m, answer;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr;
	private static boolean[][] visited, checkMinHeight, checkFill;
	private static List<int[]> pos = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//둘러쌓인 좌표 구하기
				if (checkCanFillWater(i, j, arr[i][j])) {
//					System.out.println(i + " " + j);
					//채울 수 있는 물의 최댓값 구하기
					//8~1까지 채워보기? -> 보류
					//둘러싸고 있는 값 중 최솟값
					pos.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		checkMinHeight = new boolean[n][m];
		checkFill = new boolean[n][m];
		for (int[] now : pos) {
			int x = now[0];
			int y = now[1];
			
			if (!checkMinHeight[x][y]) {
				int height = findMinHeight(x, y);
//				System.out.println(height);
				fillWater(x, y, height);
			}
		}
		System.out.println(answer);
	}
	
	private static boolean checkCanFillWater(int x, int y, int h) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		boolean[][] tempVisited = new boolean[n][m];
		tempVisited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) return false;
				if (!tempVisited[nx][ny]) {
					tempVisited[nx][ny] = true;
					if (arr[nx][ny] <= h) {
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		return true;
	}
	
	private static int findMinHeight(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		checkMinHeight[x][y] = true;
		int min = 10;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (!visited[nx][ny]) {
					min = Math.min(min, arr[nx][ny]);
				}
				
				if (visited[nx][ny] && !checkMinHeight[nx][ny]) {
					q.offer(new int[] {nx, ny});
					checkMinHeight[nx][ny] = true;
				}
			}
		}
		return min;
	}
	
	private static void fillWater(int x, int y, int h) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		checkFill[x][y] = true;
		answer += h - arr[x][y];
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (visited[nx][ny] && !checkFill[nx][ny]) {
					answer += h - arr[nx][ny];
					checkFill[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
