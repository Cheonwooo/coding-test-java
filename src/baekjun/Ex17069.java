package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17069 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		long[][][] dp = new long[n][n][3];
		
		for (int i = 0 ; i< n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (map[0][i] == 1) break;
			dp[0][i][0] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 2; j < n; j++) {
				if (map[i][j] != 1) {
					dp[i][j][0] = dp[i][j-1][1] + dp[i][j-1][0];
					dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
					
					if (map[i-1][j] != 1 && map[i][j-1] != 1) {
						dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
					}
				}
			}
		}
		
		long sum = dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];
		System.out.println(sum);
	}

}
