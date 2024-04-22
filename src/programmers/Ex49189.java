package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex49189 {
	
	public class Pair implements Comparable<Pair>{
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
	private static int[] d = new int[20001];
	private static ArrayList<ArrayList<Pair>> list = new ArrayList<>();

	public static void main(String[] args) {
		
	}
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        Arrays.fill(d, INF);
		
		for (int i = 0; i <=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edge.length; i++) {
			list.get(edge[i][0]).add(new Pair(edge[i][1], 1));
			list.get(edge[i][1]).add(new Pair(edge[i][0], 1));
		}
		
		dijkstra(1);
		
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (max < d[i]) {
				count = 1;
				max = d[i];
			} else if (max == d[i]) {
				count++;
			}
		}
		System.out.println(count);
		
        return answer;
    }
	
	public void dijkstra(int start) {
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
					pq.offer(new Pair(list.get(now).get(i).index, cost));
				}
			}
		}
	}
	
}
