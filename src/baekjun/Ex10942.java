package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 316740kb, 시간 748ms

public class Ex10942 {
	
	private static int n;
	private static int[] arr;
	private static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1][n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		palindrome();
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			sb.append(dp[from][to] + "\n");
		}
		System.out.println(sb);
	}

	public static void palindrome() {
		for (int i = 1; i < n+1; i++) {
			dp[i][i] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		
		for (int i = 2; i < n; i++ ) { 
			for (int j = 1; j+i < n+1; j++) {
				if (arr[j] == arr[j+i] && dp[j+1][j+i-1] == 1) {
					dp[j][j+i] = 1;
				}
			}
		}
	}
}
