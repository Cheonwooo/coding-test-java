package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1939 {
	
	private static final int INF = (int) 1e9;
	
	private static int n, m, e;
	private static int[] dist;
	private static List<int[]>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dist = new int[n+1];
		Arrays.fill(dist, -1);
		
		graph = new List[n+1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		dijkstra(s);
		
		System.out.println(dist[e]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		pq.offer(new int[] {start, INF});
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			int price = cur[1];
			
			if (dist[now] > price) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int to = graph[now].get(i)[0];
				int cost = Math.min(price, graph[now].get(i)[1]);
				if (cost > dist[to]) {
					dist[to] = cost;
					pq.offer(new int [] {to, cost});
				}
			}
		}
	}
}
/*
 * 1 - 2 - 3으로 가는 최솟값이 2이지만 -> 다익스트라
 * 1 - 3으로 가는 최솟값이 3이라면 어떻게 갱신할까? -> 
 */
