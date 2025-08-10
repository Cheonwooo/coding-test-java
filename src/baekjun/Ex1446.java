package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1446 {
	private static class Node implements Comparable<Node>{
		int end;
		int price;

		public Node(int end, int price) {
			this.end = end;
			this.price = price;
		}
		
		public int compareTo(Node o) {
			return this.price - o.price;
		}
	}
	
	private static int d;
	private static final int INF = (int)1e9;
	private static int[] dist;
	private static List<Node>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		dist = new int[10001];
		Arrays.fill(dist, INF);
		
		list = new List[10001];
		for (int i = 0; i < 10001; i++) {
			list[i] = new ArrayList<>();
		}
		
		List<Integer> startPoints = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, price));
			
		}
		
		dijkstra(0);
		System.out.println(dist[d]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			if (dist[node.end] < node.price) continue;
			
			if (node.end + 1 <= d && node.price + 1 < dist[node.end+1]) {
				dist[node.end + 1] = node.price + 1;
				pq.offer(new Node(node.end+1, node.price+1));
			}
			
			for (Node now : list[node.end]) {
				int cost = now.price + node.price;//지름길 이용한 위치
				
				if (cost < dist[now.end]) {
					dist[now.end] = cost;
					pq.offer(new Node(now.end, cost));
				}
			}
		}
	}

}
