package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex24444 {
	
	private static int n;
	private static int[] answer;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		answer = new int[n+1];
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
			Collections.sort(graph[i]);
		}
		bfs(r);
		
		for (int i = 1; i < n+1; i++) {
			System.out.println(answer[i]);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.offer(start);
		visited[start] = true;
		
		int index = 1;
		while (!q.isEmpty()) {
			int next = q.poll();
			
			answer[next] = index++;
			
			for (int i = 0; i < graph[next].size(); i++) {
				if (!visited[graph[next].get(i)]) {
					visited[graph[next].get(i)] = true;
					q.offer(graph[next].get(i));
				}
			}
		}
	}
}
