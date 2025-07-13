package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex17175 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[51];
		
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < 51; i++) {
			dp[i] = (1 + dp[i-1] + dp[i-2]) % 1_000_000_007;
		}
		System.out.println(dp[n]);
	}

}
