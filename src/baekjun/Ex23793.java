package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 94472kb, 시간 796ms

public class Ex23793 {
	private static class Node implements Comparable<Node> {
		int to;
		int distance;
		boolean isPass;
		
		public Node(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		}

		public Node(int to, int distance, boolean isPass) {
			this.to = to;
			this.distance = distance;
			this.isPass = isPass;
		}

		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	
	private static int n, pass;
	private static int[][] d;
	private static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		d = new int[n+1][2];
		
		for (int i = 0; i < 100001; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, distance));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		pass = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n+1; i++) {
			Arrays.fill(d[i], Integer.MAX_VALUE);
		}
		
		dijkstra(start);
		if (d[end][0] == Integer.MAX_VALUE) d[end][0] = -1;
		if (d[end][1] == Integer.MAX_VALUE) d[end][1] = -1;
		System.out.println(d[end][1] + " " + d[end][0]);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0, false));
		d[start][0] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			int to = node.to;
			int dis = node.distance;
			boolean isPass = node.isPass;
			
			if (!isPass && d[to][0] < dis) continue;
			if (isPass && d[to][1] < dis) continue;
			if (!isPass && to == pass) {
				//초기값 설정
				d[to][1] = d[to][0];
				pq.offer(new Node(to, d[to][1], true));
				continue;
			}
			
			for (int i = 0; i < list.get(to).size(); i++) {
				int passFlag = 0;
				if (isPass) passFlag = 1;				
				int cost = d[to][passFlag] + list.get(to).get(i).distance;
				if (cost < d[list.get(to).get(i).to][passFlag]) {
					d[list.get(to).get(i).to][passFlag] = cost;
					pq.offer(new Node(list.get(to).get(i).to, cost, isPass));
				}
			}
		}
	}
}
