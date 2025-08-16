package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14567 {
	
	private static int[] lesson, indegree;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		lesson = new int[n+1];
		indegree = new int[n+1];
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			indegree[to]++;
		}
		
		Queue<int[]> q = new LinkedList<>();
		for (int i = 1; i < n+1; i++) {
			if (indegree[i] == 0) {
				q.offer(new int[] {i, 1});
				lesson[i] = 1;
			}
		}
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int next : graph[now[0]]) {
				indegree[next]--;
				
				if (indegree[next] == 0) {
					lesson[next] = now[1] + 1;
					q.offer(new int[] {next, now[1] + 1});
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			System.out.print(lesson[i] + " ");
		}
	}

}
