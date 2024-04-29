package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11053_3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1);
		
		dp[1] = 1;
		
		int max = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = i-1; j >= 1; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				} else if (arr[i] == arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
				
				max = Math.max(dp[i], max);
			}
		}
		
		System.out.println(max);
	}

}
