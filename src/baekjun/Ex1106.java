package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1106 {
	
	private static final int INF = (int) 1e9;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] dp = new int[c+101];
		
		Arrays.fill(dp, INF);
		
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int price = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			for (int j = customer; j < c+101; j++) {
				dp[j] = Math.min(dp[j], dp[j-customer] + price);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = c; i < c+101; i++) {
			answer = Math.min(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
