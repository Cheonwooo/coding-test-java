package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1679 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		
		int[] dp = new int[50_001];
		Arrays.fill(dp, 50_001);
		
		for (int i = 0; i < n; i++) {
			dp[arr[i]] = 1;
			for (int j = arr[i]; j < 50_001; j++) {
				dp[j] = Math.min(dp[j], dp[j - arr[i]] + dp[arr[i]]);
			}
		}
		for (int i = 1; i <= 50_001; i++) {
			if (dp[i] > k) {
				System.out.println(((i % 2 == 0) ? "holsoon " : "jjaksoon ") + "win at " + i);
				return;
			}
		}
	}

}
