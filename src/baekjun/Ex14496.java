package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex14496 {
	
	private static int b, answer = Integer.MAX_VALUE;
	private static int[] d;
	private static boolean[] visited;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}

		d = new int[n+1];
		Arrays.fill(d, (int) 1e9);
		dijkstra(a);
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}
	
	private static void dijkstra(int start) { 
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start, 0});
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			int nowCost = cur[1];

			if (d[now] < nowCost) continue;
			
			if (now == b) {
				answer = Math.min(answer, nowCost);
				continue;
			}
			
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				int cost = nowCost + 1;
				
				if (d[next] > cost) {
					d[next] = cost;
					pq.offer(new int[] {next, cost});
				}
			}
		}
	}
}
