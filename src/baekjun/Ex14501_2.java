package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14501_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[][] arr = new int[n+1][2];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1][1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (i + arr[i][0] <= n+1) {
				dp[i] = arr[i][1];
				max = Math.max(max, dp[i]);
			}
			for (int j = i-1; j >= 1; j--) {
				if (i >= j + arr[j][0] && (i+arr[i][0]) <= n+1) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}
}
