package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 20124kb, 시간 184ms

public class Ex2176 {
	
	private static int[] dist, dp;
	private static List<int[]>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dist = new int[n+1];
		dp = new int[n+1];
		list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		Arrays.fill(dp, -1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(2);
		
		System.out.println(findReasonableRoute(1));
		
	}

	public static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		dist[start] = 0;
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			int d = cur[1];
			
			if (d > dist[now]) continue;
			
			for (int[] info : list[now]) {
				int next = info[0];
				int cost = info[1];
				
				if (dist[next] > dist[now] + cost) {
					dist[next] = dist[now] + cost;
					pq.offer(new int[] {next, dist[next]});
				}
			}
		}
	}
	
	public static int findReasonableRoute(int start) {
		if (dp[start] != -1) return dp[start];
		if (start == 2) return dp[start] = 1;
		
		dp[start] = 0;
		
		for (int[] now : list[start]) {
			if (dist[start] > dist[now[0]]) {
				dp[start] += findReasonableRoute(now[0]);
			}
		}
		return dp[start];
	}
}
