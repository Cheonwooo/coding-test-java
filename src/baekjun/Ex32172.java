package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex32172 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		boolean[] check = new boolean[1_000_001];
		
		
		dp[0] = 0;
		check[0] = true;
		for (int i = 1; i < n+1; i++) {
			dp[i] = dp[i-1] - i;
			if (dp[i] < 0 || check[dp[i]]) {
				dp[i] = dp[i-1] + i;
			}
			check[dp[i]] = true;
		}
		System.out.println(dp[n]);
	}
}
/**
 * 0 = 0
 * 1 = 0 - 1 = 1
 * 2 = 1 - 2 = 3
 * 3 = 3 - 3 = 6
 * 4 = 6 - 4 = 2
 * 5 = 2 - 5 = 7
 */
 
