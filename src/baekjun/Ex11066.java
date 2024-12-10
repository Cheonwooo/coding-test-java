package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 35508kb, 시간 1048ms

public class Ex11066 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());
			int[] files = new int[k];
			int[] preSum = new int[k];
			int[][] dp = new int[k][k];
			
			for (int i = 0; i < k; i++) {
				Arrays.fill(dp[i], 1_000_000_000);
			}
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < k; i++) {
				files[i] = Integer.parseInt(st.nextToken());
				dp[i][i] = 0;
			}
			
			preSum[0] = files[0];
			for (int i = 1; i < k; i++) {
				preSum[i] = files[i] + preSum[i-1];
			}
			
			for (int gap = 1; gap < k; gap++) {
				for (int start = 0; start < k - gap; start++) {
					for (int i = start; i < start + gap; i++) {
						dp[start][start+gap] = Math.min(dp[start][start+gap], dp[start][i] + dp[i+1][start+gap] + preSum[start+gap] - (start == 0 ? 0 : preSum[start-1]));
					}
				}
			}
			sb.append(dp[0][k-1] + "\n");
		}
		System.out.println(sb);
	}

}
