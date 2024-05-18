package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex3124_prim {
	public static class Edge implements Comparable<Edge> {
		int x;
		int cost;
		
		public Edge(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
		
		public int compareTo(Edge other) {
			return this.cost - other.cost;
		}
	}
	
	private static long answer;
	private static boolean[] visited;
	private static ArrayList<ArrayList<Edge>> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			visited = new boolean[V+1];
			
			list = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				list.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list.get(a).add(new Edge(b, c));
				list.get(b).add(new Edge(a, c));
			}
			
			answer = 0;
			prim(1);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int x = edge.x;
			int cost = edge.cost;
			
			if (visited[x]) continue;
			
			visited[x] = true;
			answer += cost;
			
			for (Edge e : list.get(x)) {
				if (!visited[e.x]) {
					pq.offer(new Edge(e.x, e.cost));
				}
			}
		}
	}
}
