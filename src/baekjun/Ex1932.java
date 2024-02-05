package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp이용
 * dp[n][1] += dp[n-1][1]
 * dp[n][k] += dp[n-1][k-1]
 * dp[n][i] = max(dp[n-1][i-1], dp[n-1][i]) + arr[n][i]
 * 2중 for문 이용 i가 3부터 n까지 for문, 2부터 i까지 for문
 * 
 * 
 * 시간복잡도
 * n * (n*(n+1))/2 = n^3
 * 
 * 자료구조
 * 입력값을 저장할 int[][]
 * dp값을 저장할 int[][]
 */

public class Ex1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[501][501];
		int[][] dp = new int[501][501];
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = arr[1][1];
		for (int i = 2; i < n+1; i++) {
			dp[i][1] = dp[i-1][1] + arr[i][1];
			dp[i][i] = dp[i-1][i-1] + arr[i][i];
		}

		for (int i = 3; i < n+1; i++) {
			for (int j = 2; j < i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
		int max = 0;
		for (int i = 0; i < n+1; i++) {
			max = Math.max(max, dp[n][i]);
		}
		System.out.println(max);
	}

}
