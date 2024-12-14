package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//메모리 424588kb, 시간 2316ms

public class Ex2533 {
	
	private static int[][] dp;
	private static boolean[] visited;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		list = new List[n+1];
		visited = new boolean[n+1];
		dp = new int[n+1][2];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		dp[start][0] = 0;//본인이 얼리어답터가 아닌 경우
		dp[start][1] = 1;//본인이 얼리어답터인 경우
		
		for (int child : list[start]) {
			if (!visited[child]) {
				dfs(child);
				dp[start][0] += dp[child][1];
				dp[start][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}

}
