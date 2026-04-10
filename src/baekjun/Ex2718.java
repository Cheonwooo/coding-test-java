package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2718 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dp = new int[1001][5];
		dp[1][0] = 1;
		
		for (int i = 2; i < 1001; i++) {
			dp[i][0] = dp[i-2][0] + dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4];
			dp[i][1] = dp[i-1][0] + dp[i-1][4];
			dp[i][2] = dp[i-1][3];
			dp[i][3] = dp[i-1][0] + dp[i-1][2];
			dp[i][4] = dp[i-1][0] + dp[i-1][1];
		}
		
		//dp[3] = ((dp[2]-1) + dp[1]) * 2 ;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n+1][0]);
		}
	}

}
