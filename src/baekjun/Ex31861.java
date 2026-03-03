package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex31861 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[m+1][27];
		
		for (int i = 1; i <= 26; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= m; i++) {
			for (int j = 1; j <= 26; j++) {
				for (int k = 1; k <= 26; k++) {
					if (Math.abs(j - k) >= n) {
						dp[i][j] = (dp[i][j] + dp[i-1][k]) % 1_000_000_007;
					}
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= 26; i++) {
			answer = (answer + dp[m][i]) % 1_000_000_007;
		}
		System.out.println(answer);
	}

}
