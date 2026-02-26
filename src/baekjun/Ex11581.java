package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex11581 {
	
	private static int n;
	private static int[] visited;
	private static boolean answer = true;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < n; i++) {
			int count = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < count; j++) {
				int next = Integer.parseInt(st.nextToken());
				graph[i].add(next);
			}
		}
		
		visited = new int[n+1];
		dfs(1);
		
		if (answer) {
			System.out.println("NO CYCLE");
		} else {
			System.out.println("CYCLE");
		}
	}
	
	private static void dfs(int start) {
		if (visited[start] == -1) {
			answer = false;
			return;
		}
		
		visited[start] = -1;
		
		for (int i = 0; i < graph[start].size(); i++) {
			int next = graph[start].get(i);
			if (visited[next] != 1) {
				dfs(next);
			}
		}
		visited[start] = 1;
	}
}
