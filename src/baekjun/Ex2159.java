package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2159 {
	private static final long INF = (long) 1e16;
	
	private static int[] dx = {0, -1, 0, 1, 0};
	private static int[] dy = {0, 0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][][] dp = new long[n+1][5][3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken())-1; 
		int sy = Integer.parseInt(st.nextToken())-1;
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		for (int i = 0; i < 5; i++) {
			dp[1][i][0] = Math.abs(sx - x - dx[i]) + Math.abs(sy - y - dy[i]);
			dp[1][i][1] = x + dx[i];
			dp[1][i][2] = y + dy[i];
		}
		
		for (int i = 2; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			for (int j = 0; j < 5; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				long min = INF;
				for (int k = 0; k < 5; k++) {
					long newCost = Math.abs(dp[i-1][k][1] - nx) + Math.abs(dp[i-1][k][2] - ny) + dp[i-1][k][0];
					min = Math.min(min, newCost);
				}
				
				dp[i][j][0] = min;
				dp[i][j][1] = nx;
				dp[i][j][2] = ny;
			}
		}
		
		long answer = INF;
		for (int i = 0; i < 5; i++) {
			answer = Math.min(answer, dp[n][i][0]);
		}
		System.out.println(answer);
	}
}
/*
 * dp
 * dp[1] = 첫 번째까지 가는 최소 길이
 * dp[2] = Math.min(dp[2], dp[1] + 가장 가까운 점까지의 거리)
 * 최소 거리가 보장되나..?
 *  
 */
