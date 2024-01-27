package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : dp
 * 10^6까지의 최솟값을 다 저장하기
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : int[]
 */

public class Ex1463 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i < n+1; i++) {
			dp[i] = dp[i-1] + 1;
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i/2] + 1, dp[i]);
			}
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
