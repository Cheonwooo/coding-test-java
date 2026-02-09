package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4803 {
	
	private static int n;
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) break;
			sb.append("Case " + (testCase++) + ": ");
			
			graph = new List[n+1];
			for (int i = 0; i < n+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			int count = 0;
			visited = new boolean[n+1];
			for (int i = 1; i< n + 1; i++) {
				if (!visited[i]) {
					if (checkTree(i)) count++;
				}
			}
			
			if (count == 0) {
				sb.append("No trees.\n");
			} else if (count == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of " + count + " trees.\n");
			}
		}
		System.out.println(sb);
	}
	
	private static boolean checkTree(int x) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(x);
		visited[x] = true;
		
		int node = 0;
		int edge = 0;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			node++;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				edge++;
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		
		return (node - 1) * 2 == edge;
	}
}
