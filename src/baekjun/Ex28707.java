package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex28707 {
	
	private static class Group implements Comparable<Group>{
		int[] arr;
		int cost;

		public Group(int[] arr, int cost) {
			this.arr = arr;
			this.cost = cost;
		}

		@Override
		public int compareTo(Group o) {
			return this.cost - o.cost;
		}
	}
	
	private static int n, m;
	private static int[] arr, start, answer;
	private static int[][] option;
	private static Map<String, Integer> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		m = Integer.parseInt(br.readLine());
		option = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			option[i][0] = Integer.parseInt(st.nextToken())-1;
			option[i][1] = Integer.parseInt(st.nextToken())-1;
			option[i][2] = Integer.parseInt(st.nextToken());
		}
		
		start = arr.clone();
		map = new HashMap<>();
		map.put(Arrays.toString(start), 0);
		
		Arrays.sort(arr);
		answer = arr.clone();
		
		dijkstra();
	}
	
	private static void dijkstra() {
		PriorityQueue<Group> pq = new PriorityQueue<>();
		pq.offer(new Group(start, 0));
		
		while (!pq.isEmpty()) {
			Group now = pq.poll();
			
			if (Arrays.equals(answer, now.arr)) {
				System.out.println(now.cost);
				return;
			}
			
			for (int[] op : option) {
				int pre = op[0];
				int next = op[1];
				int cost = op[2];
				
				int[] clone = now.arr.clone();
				
				int temp = clone[pre];
				clone[pre] = clone[next];
				clone[next] = temp;
				
				int nCost = now.cost + cost;
				String nNode = Arrays.toString(clone);
				
				if (!map.containsKey(nNode) || nCost < map.get(nNode) ) {
					pq.offer(new Group(clone, nCost));
					map.put(nNode, nCost);
				}
			}
		}
		System.out.println(-1);
	}
}
