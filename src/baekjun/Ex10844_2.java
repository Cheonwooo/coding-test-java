package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10844_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i-1][1] % 1_000_000_000;
			dp[i][9] = dp[i-1][8] % 1_000_000_000;
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
			}
		}
		
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[n][i] % 1_000_000_000;
		}
		System.out.println(sum % 1_000_000_000);
	}

}
