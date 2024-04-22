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
	
	public long solution(int n, int[][] edge) {
        
		d = new int[n+1];
        Arrays.fill(d, INF);
        d[0] = 0;
		
		for (int i = 0; i <=n; i++) {
			list.add(new ArrayList<>());
		}
		
		Arrays.stream(edge).forEach(anEdge -> {
			list.get(anEdge[0]).add(new Pair(anEdge[1], 1));
			list.get(anEdge[1]).add(new Pair(anEdge[0], 1));
		});
		
		dijkstra(1);
		
		int max = Arrays.stream(d)
				.max()
				.orElse(Integer.MIN_VALUE);
		
		long count = Arrays.stream(d)
				.filter(dist -> dist == max)
				.count();
		
        return count;
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
