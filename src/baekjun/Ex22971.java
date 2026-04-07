package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex22971 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i]++;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					dp[j] = (dp[j] + dp[i]) %  998_244_353;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(dp[i] + " " );
		}
	}

}
