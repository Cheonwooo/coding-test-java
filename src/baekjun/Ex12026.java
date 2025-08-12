package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex12026 {
	
	private static int n;
	private static char[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] != Integer.MAX_VALUE) {
					if ((arr[j] == 'B' && arr[i] == 'O') ||
							(arr[j] == 'O' && arr[i] == 'J') ||
							(arr[j] == 'J' && arr[i] == 'B')) {
						dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j));
					}
				}
			}
		}
		System.out.println((dp[n-1] != Integer.MAX_VALUE) ? dp[n-1] : -1);
	}

}
