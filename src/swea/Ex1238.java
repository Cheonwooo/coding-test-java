package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1238 {
	public static class Pair implements Comparable<Pair>{
		int x;
		int count;
		
		public Pair(int x, int count) {
			this.x = x;
			this.count = count;
		}
		
		public int compareTo(Pair other) {
			if (this.count == other.count) {
				return other.x - this.x;
			}
			return other.count - this.count;
		}
	}
	
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> list;
	private static Queue<Pair> q;
	private static PriorityQueue<Pair> pq;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#"+ t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			visited = new boolean[101];
			
			list = new ArrayList<>();
			for (int i = 0; i <= 100; i++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list.get(from).add(to);
			}
			
			q = new LinkedList<>();
			pq = new PriorityQueue<>();
			bfs(start, 0);
			
			Pair pair = pq.poll();
			sb.append(pair.x).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int start, int count) {
		q.offer(new Pair(start, count));
		pq.offer(new Pair(start, count));
		visited[start] = true;
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			
			int x = pair.x;
			count = pair.count;
			
			for (int i = 0; i < list.get(x).size(); i++) {
				int y = list.get(x).get(i);
				if (!visited[y]) {
					visited[y] = true;
					q.offer(new Pair(y, count+1));
					pq.offer(new Pair(y, count+1));
				}
			}
		}
	}

}
