package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1761 {
	
	private static class Node {
		int next;
		int dist;

		public Node(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
	}

	private static int n, height;
	private static int[] depth, d;
	private static int[][] parents;
	private static List<Node>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i < n+1; i*=2) {
			height++;
		}
		depth = new int[n+1];
		d = new int[n+1];
		
		getMaxHeight();
		parents = new int[n+1][height+1];
		
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, dist));
			graph[b].add(new Node(a, dist));
		}
		
		init(1, 1, 0, 0);
		fillParents();
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int dist = d[a] + d[b] - (d[LCA(a, b)] * 2);
			System.out.println(dist);
		}
	}
	
	private static void getMaxHeight() {
		height = (int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
	}
	
	private static void init(int now, int level, int parent, int dist) {
		depth[now] = level;
		d[now] = dist;
		for (Node next : graph[now]) {
			if (next.next != parent) {
				init(next.next, level + 1, now, dist + next.dist);
				parents[next.next][0] = now;
			}
		}
	}
	
	private static void fillParents() {
		for (int i = 1; i < height; i++) {
			for (int j = 1; j <= n; j++) {
				parents[j][i] = parents[parents[j][i-1]][i-1];
			}
		}
	}
	
	private static int LCA(int a, int b) {
		int da = depth[a];
		int db = depth[b];
		
		if (da < db) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for (int i = height-1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parents[a][i];
			}
		}
		
		if (a == b) return a;
		
		for (int i = height-1; i >= 0; i--) {
			if (parents[a][i] != parents[b][i]) {
				a = parents[a][i];
				b = parents[b][i];
			}
		}
		return parents[a][0];
	}
}
