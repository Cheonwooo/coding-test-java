package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1325 {
	
	private static int max;
	private static int[] count;
	private static boolean[] visited;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		count = new int[n+1];
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
		}
		
		for (int i = 1; i < n+1; i++) {
			visited = new boolean[n+1];
			bfs(i);
		}
		
		for (int num : count) {
			if (max < num) max = num;
		}
		
		for (int i = 1; i < n+1; i++) {
			if (max == count[i]) {
				System.out.print(i + " ");
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (visited[next]) continue;
				visited[next] = true;
				count[next]++;
				q.offer(next);
			}
		}
	}
}
