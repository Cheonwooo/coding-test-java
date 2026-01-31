package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2307 {
	
	private static final int INF = (int) 1e9;
	
	private static int n, answer;
	private static int[] d;
	private static List<int[]>[] graph;
	private static List<Integer>[] routes;
	
	public static class Route {
		int next;
		int nextCost;
		List<Integer> route;

		public Route(int next, int nextCost, List<Integer> route) {
			this.next = next;
			this.nextCost = nextCost;
			this.route = route;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		d = new int[n+1];
		graph = new List[n+1];
		routes = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
			routes[i] = new ArrayList<>();
		}
		
		int index = 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, t, index});
			graph[b].add(new int[] {a, t, index++});
		}
		
		Arrays.fill(d, INF);
		findMinRoute();
		int minDist = d[n];
		
		for (int i = 0; i < routes[n].size(); i++) {
			Arrays.fill(d, INF);
			dijkstra(routes[n].get(i));

			if (d[n] == INF) {
				System.out.println(-1);
				return;
			}
			
			if (minDist - d[n] < 0) {
				answer = Math.max(answer, d[n] - minDist);
			}
		}
		System.out.println(answer);
	}
	
	private static void findMinRoute() {
		PriorityQueue<Route> pq = new PriorityQueue<>((o1, o2) -> o1.nextCost - o2.nextCost);
		List<Integer> minRoute = new ArrayList<>();
		pq.offer(new Route(1, 0, minRoute));
		d[1] = 0;
		
		while (!pq.isEmpty()) {
			Route cur = pq.poll();
			
			int now = cur.next;
			int cost = cur.nextCost;
			List<Integer> route = cur.route;
			
			if (d[now] < cost) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i)[0];
				int nextCost = graph[now].get(i)[1];
				int nextIndex = graph[now].get(i)[2];

				if (d[next] > d[now] + nextCost) {
					List<Integer> temp = new ArrayList<>();
					temp.addAll(route);
					temp.add(nextIndex);
					d[next] = d[now] + nextCost;
					routes[next] = temp;
					pq.offer(new Route(next, d[next], temp));
				}
			}
		}
	}
	
	private static void dijkstra(int blockIndex) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {1, 0});
		d[1] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			int cost = cur[1];
			
			if (d[now] < cost) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int nextIndex = graph[now].get(i)[2];
				if (nextIndex == blockIndex) continue;
				
				int next = graph[now].get(i)[0];
				int nextCost = graph[now].get(i)[1];
				
				if (d[next] > d[now] + nextCost) {
					d[next] = d[now] + nextCost;
					pq.offer(new int[] {next, d[next]});
				}
			}
		}
	}

}
