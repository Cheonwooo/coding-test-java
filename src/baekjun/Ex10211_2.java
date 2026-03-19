package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10211_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[n];
			dp[0] = arr[0];
			int max = dp[0];
			for (int i = 1; i < n; i++) {
				if (dp[i-1] < 0) dp[i-1] = 0;
				dp[i] = dp[i-1] + arr[i];
				max = Math.max(max, dp[i]);
			}
			System.out.println(max);
		}
	}

}
