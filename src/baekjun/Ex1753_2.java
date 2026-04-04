package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1753_2 {
	
	private static final int INF = (int) 1e9;
	
	private static int[] d;
	private static List<int[]>[] list;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		d = new int[v+1];
		Arrays.fill(d, INF);
		list = new List[v+1];
		for (int i = 0; i < v+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[x].add(new int[] {y, w});
		}
		
		dijkstra(k);
		for (int i = 1; i < v+1; i++) {
			System.out.println((d[i] == INF) ? "INF" : d[i]);
		}
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start, 0});
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			if (d[now] < cur[1]) continue;
			
			for (int i = 0; i < list[now].size(); i++) {
				int[] next = list[now].get(i);
				if (d[next[0]] > d[now] + next[1]) {
					d[next[0]] = d[now] + next[1];
					pq.offer(new int[] {next[0], d[next[0]]});
				}
			}
		}
	}

}
