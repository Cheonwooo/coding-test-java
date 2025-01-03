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

// 메모리 22920kb, 시간 260ms

public class Ex1800 {
	
	private static int n, p, k;
	private static List<int[]>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[pre].add(new int[] {next, price});
			list[next].add(new int[] {pre, price});
		}
		
		int start = 0;
		int end = 1_000_001;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			int cableCnt = dijkstra(mid);
			
			if (cableCnt > k) {
				start = mid + 1;
			} else {
				end = mid - 1;;
			}
		}
		
		System.out.println(start == 1_000_002 ? -1 : start);
	}
	
	public static int dijkstra(int cost) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		pq.offer(new int[] {1, 0, 0});
		
		int[] minCnt = new int[n+1];
		Arrays.fill(minCnt, Integer.MAX_VALUE);
		minCnt[1] = 0;
		
		boolean[] visited = new boolean[n+1];
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int node = cur[0];
			int price = cur[1];
			int cnt = cur[2];
			
			if (visited[node]) continue;
			visited[node] = true;
			
			for (int[] next : list[node]) {
				int nextNode = next[0];
				int nextPrice = next[1];
				
				if (nextPrice > cost && minCnt[nextNode] > cnt + 1) {
					minCnt[nextNode] = cnt + 1;
					pq.offer(new int[] {nextNode, nextPrice, minCnt[nextNode]});
				} else if (nextPrice <= cost && minCnt[nextNode] > cnt) {
					minCnt[nextNode] = cnt;
					pq.offer(new int[] {nextNode, nextPrice, minCnt[nextNode]});
				}
			}
		}
		
		return minCnt[n];
	}

}
