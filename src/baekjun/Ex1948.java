package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1948 {

	private static int[] cost, indegree;
	private static boolean[] visited;
	private static List<int[]>[] graph, reverseGraph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		cost = new int[n+1];
		indegree = new int[n+1];
		visited = new boolean[n+1];
		
		graph = new List[n+1];
		reverseGraph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new int[] {to, cost});
			reverseGraph[to].add(new int[] {from, cost});
			indegree[to]++;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int[] next : graph[now]) {
				indegree[next[0]]--;
				cost[next[0]] = Math.max(cost[next[0]], next[1] + cost[now]);
				
				if (indegree[next[0]] == 0) {
					q.offer(next[0]);
				}
			}
		}
		
		int count = 0;
		q.offer(end);		
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int[] next : reverseGraph[now]) {
				if (cost[now] == cost[next[0]] + next[1]) {
					count++;
					if (!visited[next[0]]) {
						visited[next[0]] = true;
						q.offer(next[0]);
					}
				}
			}
		}
		
		int minCost = 0;
		for (int i = 1; i < n+1; i++) {
			minCost = Math.max(minCost, cost[i]);
		}
		
		System.out.println(minCost);
		System.out.println(count);
	}

}
