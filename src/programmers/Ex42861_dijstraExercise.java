package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 다익스트라
 * 한점에서 모든 점까지의 최소 거리 구하기
 */

public class Ex42861_dijstraExercise {
	public static class Pair implements Comparable<Pair>{
		int index;
		int distance;
		
		public Pair(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int compareTo(Pair other) {
			return this.distance - other.distance;
		}
	}
	
	private static int INF = (int) 1e9;
	private static int[] d = new int[100001];
	private static ArrayList<ArrayList<Pair>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<Pair>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			list.get(s).add(new Pair(t, distance));
		}
		
		Arrays.fill(d, INF);
		
		dijstra(start);
		
		for (int i = 1; i < n+1; i++) {
			if (d[i] == INF) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}
	}
	
	public static void dijstra(int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(start, 0));
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			
			int now = pair.index;
			int distance = pair.distance;
			
			if (d[now] < distance) continue;
			
			for (int i = 0; i < list.get(now).size(); i++) {
				int cost = d[now] + list.get(now).get(i).distance;
				
				if (cost < d[list.get(now).get(i).index]) {
					d[list.get(now).get(i).index] = cost;
					pq.offer(new Pair((list.get(now).get(i).index), cost));
				}
			}
		}
	}

}
