package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex3124_kruskal {
	public static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int cost;
		
		public Edge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		public int compareTo(Edge other) {
			return this.cost - other.cost;
		}
		
	}
	
	private static int[] parent;
	private static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			parent = new int[V+1];
			
			for (int i = 0; i <= V; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				pq.add(new Edge(a, b, c));
			}
			
			long answer = 0;
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();
				
				int x = edge.x;
				int y = edge.y;
				int cost = edge.cost;
				
				if (findParent(x) != findParent(y)) {
					unionParent(x, y);
					answer += cost;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	public static int findParent(int a) {
		if (parent[a] == a) {
			return parent[a];
		}
		return parent[a] = findParent(parent[a]);
	}
}
