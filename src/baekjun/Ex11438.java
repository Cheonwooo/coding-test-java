package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex11438 {
	
	private static int n, height;
	private static int[] depth;
	private static int[][] parents;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i < n+1; i*=2) {
			height++;
		}
		depth = new int[n+1];
		parents = new int[n+1][height];
		
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		init(1, 1, 0);
		fillParents();
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(LCA(a, b));
		}
	}
	
	private static void init(int now, int level, int parent) {
		depth[now] = level;
		parents[now][0] = parent;
		for (int next : graph[now]) {
			if (next != parent) {
				init(next, level+1, now);
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
		
		for (int i = height - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parents[a][i];
			}
		}
		
		if (a == b) return a;
		
		for (int i = height - 1; i >= 0; i--) {
			if (parents[a][i] != parents[b][i]) {
				a = parents[a][i];
				b = parents[b][i];
			}
		}
		
		return parents[a][0];
	}
}
