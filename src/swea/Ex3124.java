package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex3124 {
	private static long sum;
	private static List<List<Pair>> list;
	
	public static class Pair implements Comparable<Pair>{
		int v;
		int cost;
		
		public Pair(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		public int compareTo(Pair other) {
			return this.cost - other.cost;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for (int i = 0; i < V+1; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				list.get(A).add(new Pair(B, cost));
				list.get(B).add(new Pair(A, cost));
			}
			
			prim(1, V);
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void prim(int start, int n) {
		boolean[] visited = new boolean[n+1];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(start, 0));
		
		sum = 0;
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			
			int v = pair.v;
			int cost = pair.cost;
			
			if (visited[v]) continue;
			
			visited[v] = true;
			sum += cost;
				
			for (int i = 0; i < list.get(v).size(); i++) {
				int newV = list.get(v).get(i).v;
				int newCost = list.get(v).get(i).cost;
				
				if (!visited[newV]) {
					pq.offer(new Pair(newV, newCost));					
				}
			}
		}
	}

}
