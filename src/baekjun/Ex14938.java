package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex14938 {
	
	private static class Node implements Comparable<Node> {
		int next;
		int dist;

		public Node(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}

		public int compareTo(Node other) {
			return this.dist - other.dist; 
		}
	}
	
	private static int n, m , r;
	private static int max = Integer.MIN_VALUE;
	private static final int INF = (int) 1e9;
	private static int[] item, d;
	private static List<Node>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		item = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, cost));
			list[b].add(new Node(a, cost));
		}
		
		for (int i = 1; i <= n; i++) {
			d = new int[n+1];
			Arrays.fill(d, INF);
			dijkstra(i);
			calculateItemCount();
		}
		
		System.out.println(max);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		pq.offer(new Node(start, 0));
		d[start] = 0;
		visited[start] = true;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int next = cur.next;
			int dist = cur.dist;
			
//			if (visited[next]) continue;
			if (d[next] < dist) continue;
			
//			visited[next] = true;
			for (int i = 0; i < list[next].size(); i++) {
				int cost = list[next].get(i).dist + d[next];
				
				if (cost < d[list[next].get(i).next]) {
					d[list[next].get(i).next] = cost;
					pq.offer(new Node(list[next].get(i).next, cost));
				}
			}
		}
	}
	
	private static void calculateItemCount() {
		int sum = 0;
		for (int i = 1; i < n+1; i++) {
			if (d[i] <= m) {
				sum += item[i];
			}
		}
		
		max = Math.max(max, sum);
	}
}
