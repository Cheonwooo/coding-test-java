package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13305 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dis = new long[n];
		long[] cost = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] dp = new long[n];
		long minCost = Math.min(cost[0], cost[1]);
		dp[1] = cost[0] * dis[1];
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i-1] + minCost * dis[i];
			minCost = Math.min(minCost, cost[i]);
		}
		
		System.out.println(dp[n-1]);
	}
}

/*
 * 2������ �Ÿ���
 * 1������ �ּ� �Ÿ� + ���� cost������ �ּڰ�*dis[2]
 * 
 * 3������ �ּ� �Ÿ���
 * 2������ �ּ� �Ÿ� + ���� cost������ �ּڰ�*dist[3];
 * 
 *  
 */
