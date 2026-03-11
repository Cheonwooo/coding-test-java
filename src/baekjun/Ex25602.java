package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex25602 {
	
	private static int n, k, answer;
	private static int[] food;
	private static int[][] r, m;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		food = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			food[i] = Integer.parseInt(st.nextToken());
		}
		
		r = new int[k][n];
		m = new int[k][n];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				r[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int day, int sum) {
		if (day == k) {
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (food[i] > 0) {
				food[i]--;
				for (int j = 0; j < n; j++) {
					if (food[j] > 0) {
						food[j]--;
						dfs(day + 1, sum + r[day][i] + m[day][j]);
						food[j]++;
					}
				}
				food[i]++;
			}
		}
	}
}
