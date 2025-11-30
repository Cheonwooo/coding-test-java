package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2211 {
	
	private static class Node implements Comparable<Node> {
		int next;
		int cost;

		public Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
		
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
	
	private static final int INF = (int) 1e9;
	
	private static int n,answer = 0;
	private static int[] d, connect;
	private static List<Node>[] graph;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		connect = new int[n+1];
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		d = new int[n+1];
		Arrays.fill(d, INF);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		
		dijkstra(1);
		for (int i = 2; i < n+1; i++) {
			if (connect[i] == 0) continue;
			answer++;
			sb.append(i + " " + connect[i] + "\n");
		}
		System.out.println(answer);
		System.out.println(sb);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			int now = node.next;
			int cost = node.cost;
			
			if (d[now] < cost) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				Node next = graph[now].get(i);
				if (d[next.next] > cost + next.cost) {
					d[next.next] = cost + next.cost;
					connect[next.next] = now;
					pq.offer(new Node(next.next, d[next.next]));
				}
			}
		}
	}

}
