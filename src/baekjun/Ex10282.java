package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex10282 {
	
	private static final int INF = (int) 1e9;
	
	private static int[] time;
	private static List<int[]>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph = new List[n + 1];
			for (int i = 0; i < n + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			time = new int[n + 1];
			Arrays.fill(time, INF);
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				graph[b].add(new int[] {a, s});
			}
			
			dijkstra(c);
			
			int count = 0;
			int max = 0;
			for (int val : time) {
				if (val != INF) {
					count++;
					max = Math.max(val, max);
				}
			}
			sb.append(count + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start, 0});
		time[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			int takeTime = cur[1];
			
			if (time[now] < takeTime) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int[] next = graph[now].get(i);
				
				int cost = time[now] + next[1];
				if (cost < time[next[0]]) {
					time[next[0]] = cost;
					pq.offer(new int[] {next[0], cost});
				}
			}
		}
	}
}
