package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 17124kb, 시간 208ms

public class Ex11049 {

	private static int[][] mat;
	private static int[][] dp = new int[501][501];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		mat = new int[n+1][2];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			mat[i][0] = Integer.parseInt(st.nextToken());
			mat[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = i-1; j > 0; j--) {
				dp[j][i] = Integer.MAX_VALUE;
				for (int k = j; k < i; k++) {
					dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k+1][i] + mat[j][0]*mat[k][1]*mat[i][1]);
				}
			}
		}
		
		System.out.println(dp[1][n]);
	}

}