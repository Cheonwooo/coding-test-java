package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1753 {
	private static class Node implements Comparable<Node>{
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	private static int v, e;
	private static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	private static int[] d = new int[20001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 20001; i++) {
			list.add(new ArrayList<>());
		}
		
		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, weight));
		}
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		dijkstra(start);
		
		for (int i = 1; i <= v; i++) {
			if (d[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d[i]);
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int to = node.to;
			int distance = node.weight;
			
			if (d[to] < distance) continue;
			
			for (int i = 0; i < list.get(to).size(); i++) {
				int cost = list.get(to).get(i).weight + d[to];
				
				if (cost < d[list.get(to).get(i).to]) {
					d[list.get(to).get(i).to] = cost;
					pq.offer(new Node(list.get(to).get(i).to, cost));
				}
			}
		}
	}

}
