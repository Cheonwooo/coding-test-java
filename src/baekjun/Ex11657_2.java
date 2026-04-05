package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex11657_2 {
	
	private static class Node {
		int s;
		int e;
		int cost;

		public Node(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}
	
	private static final int INF = (int) 1e9;
	
	private static long[] d;
	private static List<Node> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		d = new long[n+1];
		Arrays.fill(d, INF);
		d[1] = 0;//출발점
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.add(new Node(a, b, c));
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Node now = graph.get(j);
				
				if (d[now.s] != INF && d[now.e] > d[now.s] + now.cost) {
					d[now.e] = d[now.s] + now.cost; 
				}
			}
		}
		
		for (int j = 0; j < m; j++) {
			Node now = graph.get(j);
			
			if (d[now.s] != INF && d[now.e] > d[now.s] + now.cost) {
				System.out.println(-1);
				return;
			}
		}
		
		for (int i = 2; i < n+1; i++) {
			System.out.println((d[i] == INF) ? -1 : d[i]);
		}
	}

}
