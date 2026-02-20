package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex11952 {
	
	private static final int INF = (int)1e9;
	
	private static int n, m, k, s, p, q;
	private static int[] dist;
	private static long[] cost;
	private static boolean[] warningCity;
	private static List<Integer> infestedCities;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		dist = new int[n+1];
		cost = new long[n+1];
		warningCity = new boolean[n+1];
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		infestedCities = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			int city = Integer.parseInt(br.readLine());
			infestedCities.add(city);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i = 0; i < infestedCities.size(); i++) {
			int city = infestedCities.get(i);
			Arrays.fill(dist, INF);
			calculateDist(city);
			findWarningCity();
		}
		
		Arrays.fill(cost, Long.MAX_VALUE);
		calculateMinCost(1);
		
		System.out.println(cost[n]);
	}
	
	private static void calculateDist(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int now = cur[0];
			if (dist[now] < cur[1]) continue;
			if (dist[now] > s) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				int cost = dist[now] + 1;
				if (dist[next] > cost) {
					dist[next] = cost;
					pq.offer(new int[] {next, cost});
				}
			}
		}
	}
	
	private static void findWarningCity() {
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] <= s) {
				warningCity[i] = true;
			}
		}
	}
	
	private static void calculateMinCost(int start) {
		PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
		pq.offer(new long[] {start, 0});
		cost[start] = 0;
		
		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			
			int now = (int)cur[0];
			if (cost[now] < cur[1]) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (infestedCities.contains(next)) continue;
				long sum = cost[now];
				if (next != n) {
					if (warningCity[next]) {
						sum += q;
					} else if (!warningCity[next]){
						sum += p;
					}
				}
					
				if (cost[next] > sum) {
					cost[next] = sum;
					pq.offer(new long[] {next, sum});
				}
			}
		}
	}
}

/*
 * k개의 점령당한 도시 저장.
 * 점령당한 도시에서 각각 다익스트라 진행
 * s번 이하의 이동 거리인 모든 도시에 대해 true 체크 -> boolean[] warningCity
 * 1번 도시에 대해 다익스트라 진행
 * warningCity[i] = true라면 q만큼, false 라면 p만큼
 * 간선의 값이 p와 q가 됨.
 * 1 -> 2 -> 5 -> 9 -> 10 -> 11 -> 12 -> 13
 * 		1000 2000 3000 4000 5000 11000 
 */
