package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3752 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			boolean[] dp = new boolean[sum+1];
			dp[0] = true;
			
			for (int i = 0; i < n; i++) {
				for (int j = sum; j >= 0; j--) {
					if (dp[j]) {
						dp[arr[i] + j] = true;
					}
				}
			}
			
			int answer = 0;
			for (int i = 0; i < dp.length; i++) {
				if (dp[i]) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
