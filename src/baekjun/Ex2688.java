package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2688 {
	
	private static long[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp = new long[65][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i < 65; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < 10; j++) {
				for (int k = j; k >= 0; k--) {
					dp[i][j] += dp[i-1][k];
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			long answer = 0;
			for (int i = 0; i < 10; i++) {
				answer += dp[n][i];
			}
			System.out.println(answer);
		}
	}

}
