package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * dp[1] = 0~9 = 10
 * dp[2] = 55
 * 00~09 : 10
 * 11~19 : 9
 * 22~29 : 8
 * ...
 * 99 : 1
 * dp[3] =   
 * 000~099 : 55
 * 111~199 : 45
 * 222~299 : 36
 * ...
 * 999 : 1
 * dp[n][0] = dp[n-1]의 합
 * dp[n][i] = dp[n][i-1]-dp[n-1][i-1]
 * 
 * 시간복잡도
 * n * 10
 * 
 * 자료구조
 * dp값을 저장할 int[][]
 * dp합을 저장할 int[] 
 * 정답을 저장할 int
 */

public class Ex11057 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[1001][10];
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i < 1001; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < j+1; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] %= 10007;
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum % 10007);
	}
}
