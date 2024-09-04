package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리 22396kb	시간 132ms

public class Ex1149_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		int[][] dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (j == k) continue;
					dp[i][j] = Math.min(arr[i][j] + arr[i-1][k], dp[i][j]);
				}
				arr[i][j] = dp[i][j];
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(dp[n-1][i], min);
		}
		System.out.println(min);
	}

}
