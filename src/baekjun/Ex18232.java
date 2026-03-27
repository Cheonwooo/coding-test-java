package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex18232 {
	private static int n, e;
	private static int[] dp;
	private static List<List<Integer>> teleport;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		teleport = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			teleport.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			teleport.get(x).add(y);
			teleport.get(y).add(x);
		}
		
		dp = new int[n+1];
		//s에서 시작해서 e까지 가는 최소 경로 = dp
		// dp[i] = dp[i-1] dp[i+1] dp[teleport[i]]
		//백트래킹
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[s] = 0;
		System.out.println(bfs(s));
	}
	
	private static int bfs(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(s);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (now == e) {
				return dp[now];
			}
			
			for (int next : teleport.get(now)) {
				if (dp[next] > dp[now] + 1) {
					dp[next] = dp[now] + 1;
					q.offer(next);
				}
			}
			
			if (now + 1 <= n && dp[now+1] > dp[now] + 1) {
				dp[now+1] = dp[now] + 1;
				q.offer(now + 1);
			}
			
			if (now - 1 > 0 && dp[now-1] > dp[now] + 1) {
				dp[now-1] = dp[now] + 1;
				q.offer(now - 1);
			}
		}
		return 0;
		
		
	}

}
