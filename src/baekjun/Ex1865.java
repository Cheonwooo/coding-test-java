package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1865 {
	
	private static class Node {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	private static final int INF = (int)1e9;
	private static int n, m, w;
	private static int[] d;
	private static List<Node> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				list.add(new Node(s, e, t));
				list.add(new Node(e, s, t)); 
			}
			
			for (int j = 0; j < w; j++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken()) * (-1);
				
				list.add(new Node(s, e, t)); 
			}

			d = new int[n+1];
			boolean check = false;
			for (int j = 1; j < n+1; j++) {
				if (bellmanFord(j)) {
					check = true;
					System.out.println("YES");
					break;
				}
			}
			if (!check) System.out.println("NO");
		}
	}
	
	private static boolean bellmanFord(int start) {
		Arrays.fill(d, INF);
		d[start] = 0;
		boolean update = false;
		
		for (int i = 1; i < n; i++) {
			update = false;
			for (Node node : list) {
				if (d[node.start] != INF && d[node.end] > d[node.start] + node.cost) {
					d[node.end] = d[node.start] + node.cost;
					update = true;
				}
			}
			
			if (!update) break;
		}
		
		for (Node node : list) {
			if (d[node.start] != INF && d[node.end] > d[node.start] + node.cost) {
				return true;
			}
		}
		return false;
	}

}
