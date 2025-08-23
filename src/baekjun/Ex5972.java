package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex5972 {
	
	private static final int INF = (int) 1e9;
	private static int[] d;
	private static List<int[]>[] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		d = new int[n+1];
		Arrays.fill(d, INF);
		
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		dijkstra(1);
		
		System.out.println(d[n]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start, 0});
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			int dist = cur[1];
			
			if (d[now] < dist) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i)[0];
				int cost = graph[now].get(i)[1] + d[now];
				
				if (cost < d[next]) {
					d[next] = cost;
					pq.offer(new int[] {next, cost});
				}
			}
		}
	}

}
