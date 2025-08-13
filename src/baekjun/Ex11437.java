package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex11437 {
	
	private static int[] parents, depth;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		depth = new int[n+1];
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
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(LCA(a, b));
		}
	}

	private static void init(int now, int level, int parent) {
		parents[now] = parent;
		depth[now] = level;
		for (int next : graph[now]) {
			if (next != parent) {
				init(next, level+1, now);
			}
		}
	}
	
	private static int LCA(int a, int b) {
		int da = depth[a];
		int db = depth[b];
		
		while (da > db) {
			a = parents[a];
			da--;
		}
		
		while (db > da) {
			b = parents[b];
			db--;
		}
		
		while (a != b) {
			a = parents[a];
			b = parents[b];
		}
		
		return a;
	}
}
