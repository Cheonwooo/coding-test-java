package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp이용
 * dp[n][k] = dp[n-1][k] + dp[n][k-1]
 * dp[n][1] = n개
 * dp[1][k] = k개
 * 
 * 시간복잡도
 * n * k
 * 
 * 자료구조
 * dp값을 저장할 int[]
 * 정답을 저장할 int
 * 
 */

public class Ex2225 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n+1][k+1];
		
		for (int i = 1; i < n+1; i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		
		for (int i = 0; i < k+1; i++) {
			dp[1][i] = i;
		}
		
		for (int i = 2; i < n+1; i++) {
			for (int j = 2; j < k+1; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_000;
			}
		}
		System.out.println(dp[n][k] % 1_000_000_000);
	}

}
