package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1916 {
	private static class Node implements Comparable<Node> {
		int node;
		int dist;

		public Node(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
	}
	
	private static int[] d;
	private static List<Node>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		d = new int[n+1];
		
		Arrays.fill(d, (int)1e9);
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, price));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(d[end]);
	}
	
	private static void dijkstra(int start) {
		d[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node (start, 0));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int now = cur.node;
			int dist = cur.dist;
			
			if (d[now] < dist) continue;
			
			for (int i = 0; i < list[now].size(); i++) {
				int cost = d[now] + list[now].get(i).dist;
				
				if (cost < d[list[now].get(i).node]) {
					d[list[now].get(i).node] = cost;
					pq.offer(new Node (list[now].get(i).node, cost));
				}
			}
		}
		
	}

}
