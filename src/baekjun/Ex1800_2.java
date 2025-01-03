package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 22776kb, 시간 268ms

public class Ex1800_2 {
	
	private static int n, p, k;
	private static int[] dis;
	private static List<int[]>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		dis = new int[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			max = Math.max(max, price);
			list[pre].add(new int[] {next, price});
			list[next].add(new int[] {pre, price});
		}
		
		int start = 0;
		int end = max;
		
		int answer = Integer.MIN_VALUE;
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (dijkstra(mid)) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(answer == Integer.MIN_VALUE ? -1 : answer);
	}
	
	public static boolean dijkstra(int cost) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		pq.offer(new int[] {1, 0});
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int node = cur[0];
			int cnt = cur[1];
			
			if (dis[node] < cnt) continue;
			
			for (int[] next : list[node]) {
				int nextNode = next[0];
				int nextPrice = next[1];
				int nextCnt = cnt;
				
				if (nextPrice > cost) {
					nextCnt++;
				}
				
				if (nextCnt < dis[nextNode]) {
					dis[nextNode] = nextCnt;
					pq.offer(new int[] {nextNode, nextCnt});
				}
			}
		}
		
		return dis[n] <= k;
	}

}
