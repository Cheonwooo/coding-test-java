package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1251 {
	public static class Edge implements Comparable<Edge>{
		int x;
		int y;
		long cost;
		
		public Edge(int x, int y, long cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		public int compareTo(Edge other) {
			return Long.compare(this.cost, other.cost);
		}
	}
	
	private static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			int[] x = new int[n];
			int[] y = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			parents = new int[n];
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					long distance = (long)Math.pow(x[i]-x[j], 2) + (long)Math.pow(y[i] - y[j], 2);
					
					pq.offer(new Edge(i, j, distance));
				}
			}
			
			long answer = 0;
			int count = 0;
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();
				int a = edge.x;
				int b = edge.y;
				
				if (unionParent(a, b)) continue;
				answer += edge.cost;
				count++;
				
				if (count == n-1) break;
			}
			
			sb.append(Math.round(answer*E)).append("\n");
		}
		System.out.println(sb);
	}
	public static int findParent(int a) {
		if (parents[a] == a) return parents[a];
		else return parents[a] = findParent(parents[a]);
	}
	
	public static boolean unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a != b) {
			if (a < b) {
				parents[b] = a;
				return false;
			} else {
				parents[a] = b;
				return false;
			}
		}
		return true;
	}
}
