package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 : 55660kb, 시간 : 588ms

public class Ex1238 {
	
	private static class Node implements Comparable<Node> {
		int to;
		int distance;
		
		public Node(int to, int distance) {
			this.to = to;
			this.distance = distance;
		}
		
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	
	private static int n;
	private static int[] endD, takeTime;
	private static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		endD = new int[1001];
		takeTime = new int[1001];
		
		for (int i = 0; i <= 1000; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, distance));
		}
		
		for (int i = 1; i <= n; i++) {
			if (i == x) {
				Arrays.fill(endD, Integer.MAX_VALUE);
				dijkstra(endD, i);
			} else {
				int[] startD = new int[1001];
				Arrays.fill(startD, Integer.MAX_VALUE);
				dijkstra(startD, i);
				takeTime[i] = startD[x];
			}
		}
		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {//각 학생들이 x에 도착하는 최대 시간
			int sum = takeTime[i] + endD[i];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
	
	public static void dijkstra(int[] d, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			int to = node.to;
			int dis = node.distance;
			
			if (d[to] < dis) continue;
			
			for (int i = 0; i < list.get(to).size(); i++) {
				int cost = d[to] + list.get(to).get(i).distance;
				if (cost < d[list.get(to).get(i).to]) {
					d[list.get(to).get(i).to] = cost;
					pq.offer(new Node(list.get(to).get(i).to, cost));
				}
			}
		}
	}

}
