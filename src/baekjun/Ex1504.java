package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1504 {
	
	private static class Node implements Comparable<Node> {
		int next;
		int price;

		public Node(int next, int price) {
			this.next = next;
			this.price = price;
		}
		
		public int compareTo(Node other) {
			return this.price - other.price;
		}
	}
	
	private static int n;
	private static int INF = (int)1e9;
	private static int[] dis;
	private static List<Node>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, price));
			list[to].add(new Node(from, price));
		}
		
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		
		int sumFirst = 0;
		sumFirst += dijkstra(1, first);
		sumFirst += dijkstra(first, second);
		sumFirst += dijkstra(second, n);
		
		int sumSecond = 0;
		sumSecond += dijkstra(1, second);
		sumSecond += dijkstra(second, first);
		sumSecond += dijkstra(first, n);
		
		int min = Math.min(sumFirst, sumSecond);
		if (e == 0 || min >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dis = new int[n+1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (dis[cur.next] < cur.price) continue;
			
			for (int i = 0; i < list[cur.next].size(); i++) {
				int cost = list[cur.next].get(i).price + dis[cur.next];
				if (cost < dis[list[cur.next].get(i).next]) {
					dis[list[cur.next].get(i).next] = cost;
					pq.offer(new Node(list[cur.next].get(i).next, cost));
				}
			}
		}
		
		return dis[end];
	}

}
