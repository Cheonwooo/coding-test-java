package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex21937 {
	
	private static int n;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			graph[next].add(pre);
		}
		
		int x = Integer.parseInt(br.readLine());
		int answer = bfs(x);
		System.out.println(answer);
	}
	
	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.offer(start);
		visited[start] = true;
		
		int count = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (!visited[next]) {
					visited[next] = true;
					count++;
					q.offer(next);
				}
			}
		}
		return count;
	}

}
