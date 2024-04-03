package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 아이디어
 * bfs로 풀기
 */

public class Ex42898 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n][m];
		int[][] map = new int[n][m];
		
		for (int i = 0; i < puddles.length; i++) {
			int y = puddles[i][0];
			int x = puddles[i][1];
			
			map[x-1][y-1] = -1;
		}
		
		dp[0][0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) continue;
				
				if (i > 0) {
					dp[i][j] += dp[i-1][j] % 1_000_000_007;
				}
				if (j > 0) {
					dp[i][j] += dp[i][j-1] % 1_000_000_007;
				}
			}
		}
		
		return dp[n-1][m-1] % 1_000_000_007;
    }
	
	
}
