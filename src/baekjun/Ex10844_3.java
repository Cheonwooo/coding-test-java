package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex10844_3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		
		for (int i = 2; i < n+1; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] += dp[i-1][j+1] % 1_000_000_000;
				} else if (j == 9) {
					dp[i][j] += dp[i-1][j-1] % 1_000_000_000;
				} else {
					dp[i][j] += (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
				}
			} 
		}
		
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i] % 1_000_000_000;
		}
		System.out.println(sum % 1_000_000_000);
	}

}
