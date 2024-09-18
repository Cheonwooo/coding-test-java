package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 149672kb, 시간 1140ms

public class Ex23801 {
	
	private static class Node implements Comparable<Node> {
		int to;
		long distance;
		boolean isPass;
		
		public Node(long distance, boolean isPass) {
			super();
			this.distance = distance;
			this.isPass = isPass;
		}

		public Node(int to, long distance) {
			super();
			this.to = to;
			this.distance = distance;
		}
		
		public Node(int to, long distance, boolean isPass) {
			this.to = to;
			this.distance = distance;
			this.isPass = isPass;
		}

		public int compareTo(Node o) {
			return Long.compare(this.distance, o.distance);
		}
	}
	
	private static int n;
	private static boolean[] check;
	private static Node[][] nodes;
	private static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		nodes = new Node[n+1][2];
		
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
			for (int j = 0; j < 2; j++ ) {
				nodes[i][j] = new Node(Long.MAX_VALUE, false);
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Node(to, distance));
			list.get(to).add(new Node(from, distance));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int size = Integer.parseInt(br.readLine());
		check = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			check[Integer.parseInt(st.nextToken())] = true;
		}
		
		dijkstra(start);
		if (nodes[end][1].distance == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(nodes[end][1].distance);
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0, false));
		nodes[start][0].distance = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			int to = node.to;
			long dis = node.distance;
			boolean checkPass = node.isPass;
			
			if (!checkPass && nodes[to][0].distance < dis) continue;
			if (checkPass && nodes[to][1].distance < dis) continue;
			if (!checkPass && check[to]) {
				checkPass = true;
				nodes[to][1].distance = nodes[to][0].distance;
				pq.offer(new Node(to, nodes[to][1].distance, true));
				continue;
			}
			
			for (int i = 0; i < list.get(to).size(); i++) {
				int passFlag = 0;
				if (checkPass) passFlag = 1;
				long cost = nodes[to][passFlag].distance + list.get(to).get(i).distance;
				if (cost < nodes[list.get(to).get(i).to][passFlag].distance) {
					nodes[list.get(to).get(i).to][passFlag].distance = cost;
					pq.offer(new Node(list.get(to).get(i).to, cost, checkPass));
				}
			}
		}
	}

}
