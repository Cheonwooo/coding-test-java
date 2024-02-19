package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11053_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1;
		int max = dp[1];
		for (int i = 2; i < n+1; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(max, dp[i]);
			}
		}
		System.out.println(max);
	}

}
