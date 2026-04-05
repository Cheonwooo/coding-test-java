package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2252 {
	
	private static int[] inDegree;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		inDegree = new int[n+1];
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			inDegree[b]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < n+1; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		boolean[] isDuplicated = new boolean[n+1];
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (!isDuplicated[now]) {
				isDuplicated[now] = true;
				sb.append(now + " ");
			}
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				inDegree[next]--;
				if (inDegree[next] == 0) {
					q.add(next);
				}
			}
		}
		System.out.println(sb);
	}

}
