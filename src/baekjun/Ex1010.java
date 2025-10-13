package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1010 {
	
	private static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(combi(y, x) + "\n");
		}
		System.out.println(sb);
	}
	
	private static int combi(int x, int y) {
		if (dp[x][y] > 0) {
			return dp[x][y];
		}
		
		if (x == y || y == 0) {
			return dp[x][y] = 1;
		}
		
		return dp[x][y] = combi(x-1, y-1) + combi(x-1, y);
	}
}
