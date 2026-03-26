package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1912_5 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		int[] dp = new int[n+1];
		Arrays.fill(sum, -1_000_000_001);
		Arrays.fill(dp, -1_000_000_001);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = Math.max(sum[i-1] + arr[i], arr[i]);
			dp[i] = Math.max(dp[i-1], sum[i]);
		}
		System.out.println(dp[n]);
	}

}
