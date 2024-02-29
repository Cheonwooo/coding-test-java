package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10971_2 {
	private static int n, min;
	private static int[][] cost;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		cost = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			perm(i, i, 0, 0);
		}
		System.out.println(min);
	}
	
	private static void perm(int start, int now, int depth, int sum) {
		if (depth == n-1) {
			if (cost[now][start] != 0) {
				min = Math.min(min, sum + cost[now][start]);
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i] && cost[now][i] != 0) {
				visited[i] = true;
				perm(start, i, depth+1, sum + cost[now][i]);
				visited[i] = false;
			}
		}
	}

}
