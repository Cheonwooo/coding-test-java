package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex10164 {

	private static long[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		dp = new long[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int mx = 0, my= 0;
		if (k != 0) {
			int index = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (index++ == k) {
						mx = i;
						my = j;
						break;
					}
				}
			}
			long answer = findRoute(0, 0, mx, my) * findRoute(mx, my, n-1, m-1);
			System.out.println(answer);
		} else {
			System.out.println(findRoute(0, 0, n-1, m-1));
		}
		
	}
	
	private static long findRoute(int x, int y, int fx, int fy) {
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		
		if (x == fx && y == fy) {
			return 1;
		}
		
		dp[x][y] = 0;
		if (x + 1 <= fx && y <= fy) {
			dp[x][y] += findRoute(x+1, y, fx, fy);
		}
		
		if (x <= fx && y + 1 <= fy) {
			dp[x][y] += findRoute(x, y+1, fx, fy);
		}
		return dp[x][y];
	}
}

