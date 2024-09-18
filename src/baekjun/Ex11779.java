package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex11779 {
	
	private static class Node implements Comparable<Node> {
		int index;
		int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int compareTo(Node o) { 
			return this.distance - o.distance;
		}
		
	}
	
	private static int n, end;
	private static int[] d, preNode;
	private static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		d = new int[n+1];
		preNode = new int[n+1];
		
		for (int i = 0; i <= 1000; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, price));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		dijkstra(start);
		System.out.println(d[end]);
		ArrayList<Integer> route = new ArrayList<>();
		int current = end;
		while (current != 0) {
			route.add(current);
			current = preNode[current];
		}
		System.out.println(route.size());
		for (int i = route.size()-1; i >= 0; i--) {
			System.out.print(route.get(i) + " ");
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		preNode[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			int now = node.index;
			int dis = node.distance;
			
			if (d[now] < dis) continue;
			
			for (int i = 0; i < list.get(now).size(); i++) {
				int cost = d[now] + list.get(now).get(i).distance;
				if (cost < d[list.get(now).get(i).index]) {
					d[list.get(now).get(i).index] = cost;
					preNode[list.get(now).get(i).index] = now;
					pq.offer(new Node(list.get(now).get(i).index, cost));
				}
			}
		}
	}
}
