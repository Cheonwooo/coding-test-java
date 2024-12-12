package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 15264kb, 시간 112ms

public class Ex7579 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int usedMemory = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[n];
		int[] memory = new int[n];
		int[][] dp = new int[n][10001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int c = cost[i];
			int m = memory[i];
			
			for (int j = 0; j < 10001; j++) {
				if (i == 0) {
					if (j >= c) {
						dp[i][j] = m;
					}
				} else {
					if (j >= c) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c] + m);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
				if (dp[i][j] >= usedMemory) {
					answer = Math.min(answer, j);
				}
			}
		}
		
		System.out.println(answer);
	}

}
