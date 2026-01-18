package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex24447 {
	
	private static int n, seq = 1;
	private static int[] d, t;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		graph = new List[n+1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for (int i = 0; i < n+1; i++) {
			Collections.sort(graph[i]);
		}
		
		d = new int[n+1];
		t = new int[n+1];
		
		Arrays.fill(d, -1);
		
		d[1] = 0;
		t[1] = seq++;
		
		bfs(r);
		
		long answer = 0;
		for (int i = 1; i < n + 1; i++) {
			answer += ((long)d[i] * (long)t[i]);
		}
		System.out.println(answer);
	}

	private static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		visited[start] = true;
		q.offer(new int[] {start, d[1]});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int now = cur[0];
			int depth = cur[1];
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				
				if (!visited[next]) {
					visited[next] = true;
					d[next] = depth + 1;
					t[next] = seq++;
					q.offer(new int[] {next, d[next]});
				}
			}
		}
	}
}
