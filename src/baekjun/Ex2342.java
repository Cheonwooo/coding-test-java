package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 메모리 53744kb, 시간 572ms

public class Ex2342 {
	
	private static int[][][] dp;
	private static List<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			int next = Integer.parseInt(st.nextToken());
			
			if (next == 0) break;
			list.add(next);
		}
		
		dp = new int[5][5][list.size()];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(dfs(0, 0, 0));
	}
	
	public static int dfs (int left, int right, int depth) {
		if (depth == list.size()) return 0;
		
		if (dp[left][right][depth] != -1) return dp[left][right][depth];
		
		dp[left][right][depth] = Math.min(dfs(list.get(depth), right, depth+1) + move(left, list.get(depth)),
											dfs(left, list.get(depth), depth+1) + move(right, list.get(depth)));
		
		return dp[left][right][depth];
	}
	
	public static int move (int pre, int next) {
		if (pre == 0) return 2;
		else if (pre == next) return 1;
		else if (Math.abs(pre - next) == 2) return 4;
		else return 3;
	}
}
