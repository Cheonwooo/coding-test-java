package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex24484 {
	
	private static int s = 1;
	private static long[] depth, seq;
	private static boolean[] visited;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		depth = new long[n+1];
		seq = new long[n+1];
		Arrays.fill(depth, -1);
		
		visited = new boolean[n+1];
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for (int i = 1; i < n+1; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}
		
		dfs(0, r);
//		System.out.println(Arrays.toString(seq));
//		System.out.println(Arrays.toString(depth));
		long answer = 0;
		for (int i = 1; i < n+1; i++) {
			answer += depth[i] * seq[i];
		}
		System.out.println(answer);
	}
	
	private static void dfs(int d, int start) {
		visited[start] = true;
		depth[start] = d;
		seq[start] = s++;
		
		for (int next : graph[start]) {
			if (!visited[next]) {
				dfs(d + 1, next);
			}
		}
	}
}
