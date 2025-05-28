package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1389 {
	
	private static class Node implements Comparable<Node> {
		int node;
		int cost;
		
		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
		
		public int compareTo(Node other) {
			if (this.cost == other.cost) {
				return this.node - other.node;
			}
			return this.cost - other.cost;
		}
	}
	
	private static final int INF = (int)1e9;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n+1][n+1];
		
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (i == j) continue;
				graph[i][j] = INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			graph[pre][next] = 1;
			graph[next][pre] = 1;
		}
		
		floyd(graph, n);
		System.out.println(findAnswer(graph, n));
	}
	
	private static void floyd(int[][] graph, int n) {
		for (int k = 1; k < n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}
	
	private static int findAnswer(int[][] graph, int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i < n+1; i++) {
			int sum = 0;
			for (int j = 1; j < n+1; j++) {
				if (graph[i][j] != INF) sum += graph[i][j]; 
			}
			pq.offer(new Node(i, sum));
		}
		
		Node node = pq.poll();
		return node.node;
	}

}
