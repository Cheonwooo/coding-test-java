package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex25418 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[1_000_001];
		Arrays.fill(dp, 1_000_001);
		
		dp[a] = 0;
		for (int i = a+1; i <= k; i++) {
			dp[i] = dp[i-1];
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]);
			}
			dp[i]++;
		}
		System.out.println(dp[k]);
	}

}
