package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12865_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k+1];
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for (int j = k; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j-w]+v); 
			}
		}
		
		int answer = 0;
		for (int i = 0; i < k+1; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
