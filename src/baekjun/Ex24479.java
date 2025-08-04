package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex24479 {
	
	private static int count = 1;
	private static int[] answer;
	private static boolean[] visited;
	private static List[] node;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		answer = new int[n+1];
		node = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			node[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			node[u].add(v);
			node[v].add(u);
		}
		
		for (int i = 1; i < n+1; i++) {
			Collections.sort(node[i]);
		}
		
		visited = new boolean[n+1];
		dfs(r);
		
		for (int i = 1; i < n+1; i++) {
			System.out.println(answer[i]);
		}
	}
	
	private static void dfs(int start) {
		if (answer[start] == 0) answer[start] = count++; 
		visited[start] = true;
		
		for (int i = 0; i < node[start].size(); i++) {
			int next = (int)node[start].get(i);
			if (!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
	}

}
