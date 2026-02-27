package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex18249 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[191230];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 191230; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(dp[n]);
		}
	}

}
