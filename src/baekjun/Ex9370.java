package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 61644kb, 시간 468kb

public class Ex9370 {
	
	private static class Pair implements Comparable<Pair>{
		int to;
		int dis;
		boolean isPass;
		
		public Pair(int dis, boolean isPass) {
			this.dis = dis;
			this.isPass = isPass;
		}
		
		public Pair(int to, int dis, boolean isPass) {
			this.to = to;
			this.dis = dis;
			this.isPass = isPass;
		}

		public int compareTo(Pair o) {
			if (this.dis == o.dis) {
				return Boolean.compare(o.isPass, this.isPass);
			}
			return this.dis - o.dis;
		}

		@Override
		public String toString() {
			return "Pair [to=" + to + ", dis=" + dis + ", isPass=" + isPass + "]";
		}
		
		
	}
	
	private static final int INF = (int) 1e9;
	private static int n;
	private static Pair[] d;
	private static List<Pair>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			
			d = new Pair[n+1];
			for (int i = 0; i < n+1; i++) {
				d[i] = new Pair(INF, false);
			}
			
			list = new List[n+1];
			for (int i = 0; i < n+1; i++) {
				list[i] = new ArrayList<Pair>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				
				list[from].add(new Pair(to, dis, false));
				list[to].add(new Pair(from, dis, false));
			}
			
			dijkstra(s, g, h);
			
			List<Integer> answer = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				int x = Integer.parseInt(br.readLine());
				if (d[x].isPass) {
					answer.add(x);
				}
			}
			
			Collections.sort(answer);
			for(int val : answer) {
				sb.append(val + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dijkstra(int start, int g, int h) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		boolean[] visited = new boolean[n+1];
		d[start].dis = 0;
		pq.add(new Pair(start, 0, false));
		
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int to = p.to;
			int dis = p.dis;
			boolean isPass = p.isPass;
			
			if (d[to].dis < dis) continue;
			
			if (visited[to]) continue;
			visited[to] = true;
			
			for (int i = 0; i < list[to].size(); i++) {
				int dist = list[to].get(i).dis + d[to].dis;
				
				if (dist < d[list[to].get(i).to].dis) {
					if ((to == g && list[to].get(i).to == h) ||
							(to == h && list[to].get(i).to == g)) {//경유지를 통과했다면 체크
						d[list[to].get(i).to].dis = dist;
						d[list[to].get(i).to].isPass = true;
						
						pq.offer(new Pair(list[to].get(i).to, dist, true));
					} else {
						d[list[to].get(i).to].dis = dist;
						d[list[to].get(i).to].isPass = isPass;
						
						pq.offer(new Pair(list[to].get(i).to, dist, isPass));
					}
				} else if (dist == d[list[to].get(i).to].dis) {
					if ((to == g && list[to].get(i).to == h) ||
							(to == h && list[to].get(i).to == g) ||
							isPass || d[list[to].get(i).to].isPass) {//거리가 같은 겨우 경유지를 통과했는지 체크
						d[list[to].get(i).to].isPass = true;
						
						pq.offer(new Pair(list[to].get(i).to, dist, true));
					}
				}
			}
		}
	}
}
