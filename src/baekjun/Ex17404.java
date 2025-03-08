package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 메모리 14648kb, 시간 116ms

public class Ex17404 {
	
	private static int n, answer = Integer.MAX_VALUE;
	private static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
//		dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			
//			Arrays.fill(dp[i], (int)1e9);
		}
		
		for (int i = 0; i < 3; i++) {
			calculateMin(i);
		}
		System.out.println(answer);
	}
	
	private static void calculateMin(int start) {
		int[][] dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], (int)1e9);
		}
		
		for (int i = 0; i < 3; i++) {
			if (i == start) continue;
			dp[1][i] = arr[0][start] + arr[1][i];
		}
		
		for (int i = 2; i < n-1; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}
		
		if (n > 2) {
			if (start == 0) {
				dp[n-1][1] = Math.min(dp[n-2][0], dp[n-2][2]) + arr[n-1][1];
				dp[n-1][2] = Math.min(dp[n-2][0], dp[n-2][1]) + arr[n-1][2];
			} else if (start == 1) { 
				dp[n-1][0] = Math.min(dp[n-2][1], dp[n-2][2]) + arr[n-1][0];
				dp[n-1][2] = Math.min(dp[n-2][0], dp[n-2][1]) + arr[n-1][2];
			} else if (start == 2) {
				dp[n-1][0] = Math.min(dp[n-2][1], dp[n-2][2]) + arr[n-1][0];
				dp[n-1][1] = Math.min(dp[n-2][0], dp[n-2][2]) + arr[n-1][1];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, dp[n-1][i]);
		}
	}

}
