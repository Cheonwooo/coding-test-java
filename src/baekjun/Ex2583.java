package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Ex2583 {
	
	private static int n, m, count;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] map;
	private static List<Integer> answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new boolean[m][n];
		
		for (int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = true;
				}
			}
		}
		
		answer = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!map[i][j]) {
					count = 1;
					dfs(i, j);
					answer.add(count);
				}
			}
		}
		
		System.out.println(answer.size());
		Collections.sort(answer);
		for (int num : answer) {
			System.out.print(num + " ");
		}
	}
	
	private static void dfs(int x, int y) {
		map[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[nx][ny]) continue;
			map[nx][ny] = true;
			count++;
			dfs(nx, ny);
		}
	}
}
