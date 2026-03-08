package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex18430 {
	
	private static int n, m, answer;
	private static int[][] arr;
	private static boolean[][] visited;
	private static List<int[]>[] list = new List[4];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		init();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(answer);
	}
	
	private static void init() {
		for (int i = 0; i < 4;i ++) {
			list[i] = new ArrayList<>();
		}
		
		list[0].add(new int[] {1, 0});
		list[0].add(new int[] {0, -1});
		list[1].add(new int[] {-1, 0});
		list[1].add(new int[] {0, -1});
		list[2].add(new int[] {-1, 0});
		list[2].add(new int[] {0, 1});
		list[3].add(new int[] {1, 0});
		list[3].add(new int[] {0, 1});
	}

	private static boolean checkMake(int x, int y, int l) {
		int x1 = x + list[l].get(0)[0];
		int y1 = y + list[l].get(0)[1];
		int x2 = x + list[l].get(1)[0];
		int y2 = y + list[l].get(1)[1];
		
		return (0 <= x1 && x1 < n && 0 <= y1 && y1 < m &&
				0 <= x2 && x2 < n && 0 <= y2 && y2 < m &&
				!visited[x1][y1] && !visited[x2][y2]);
	}
	
	private static void dfs(int index, int sum) {
		int i = index / m;
		int j = index % m;
		if (index == n * m) {
			answer = Math.max(answer, sum);
			return;
		}
		
		if (!visited[i][j]) {
			for (int l = 0; l < 4; l++) {
				if (checkMake(i, j, l)) {
					int x1 = i + list[l].get(0)[0];
					int y1 = j + list[l].get(0)[1];
					int x2 = i + list[l].get(1)[0];
					int y2 = j + list[l].get(1)[1];
					visited[i][j] = true;
					visited[x1][y1] = true;
					visited[x2][y2] = true;
					int sepSum = arr[i][j]*2 + arr[x1][y1] + arr[x2][y2];
					dfs(index + 1, sum + sepSum);
					visited[i][j] = false;
					visited[x1][y1] = false;
					visited[x2][y2] = false;
				}
			}
		}
		dfs(index + 1, sum);
	}
}
