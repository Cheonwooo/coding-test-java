package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex27914 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		long[] dp = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		if (dp[0] != k) {
			dp[0] = 1;
			count++;
		} else {
			dp[0] = 0;
		}
		
		for (int i = 1; i < n; i++) {
			if (dp[i] != k) {
				count++;
				dp[i] = dp[i-1] + count;
			} else {
				count = 0;
				dp[i] = dp[i-1];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			int next = Integer.parseInt(st.nextToken())-1;
			System.out.println(dp[next]);
		}
	}

}
