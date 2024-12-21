package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 55372kb, 시간 1056ms

public class Ex1719 {
	
	private static class Route implements Comparable<Route>{
		int now;
		int dist;
		List<Integer> route;
		
		public Route(int now, int dist, List<Integer> route) {
			this.now = now;
			this.dist = dist;
			this.route = route;
		}

		@Override
		public String toString() {
			return "Route [now=" + now + ", dist=" + dist + ", route=" + route + "]";
		}
		
		public int compareTo(Route o) {
			return this.dist - o.dist;
		}
	}
	
	private static int n;
	private static Route[] routes;
	private static int[][] arr;
	private static List<int[]>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		routes = new Route[n+1];
		arr = new int[n][n];
		list = new List[n+1];
		
		for (int i = 1; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[from].add(new int[] {to, price});
			list[to].add(new int[] {from, price});
		}
		
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				routes[j] = new Route(j, Integer.MAX_VALUE, new ArrayList<Integer>(List.of(j)));
			}
			dijkstra(i);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					System.out.print("- ");
				} else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Route> pq = new PriorityQueue<>();
		routes[start].dist = 0;
		pq.offer(routes[start]);
		
		while (!pq.isEmpty()) {
			Route cur = pq.poll();
			
			int now = cur.now;
			int dist = cur.dist;
			List<Integer> route = cur.route;
			if (routes[now].dist > dist) continue;
			
			for (int i = 0; i < list[now].size(); i++) {
				int cost = routes[now].dist + list[now].get(i)[1];
				List<Integer> tempList;
				if (cost < routes[list[now].get(i)[0]].dist) {
					routes[list[now].get(i)[0]].dist = cost;
					tempList = new ArrayList<>(route);
					tempList.add(list[now].get(i)[0]);
					arr[start-1][list[now].get(i)[0]-1] = tempList.get(1);
					pq.offer(new Route(list[now].get(i)[0], cost, tempList));
				}
			}
		}
	}
}