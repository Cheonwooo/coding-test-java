package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 274960kb, 시간 772ms

public class Ex1005 {
	
	private static int n, w;
	private static int[] inDegree, times, sum;
	private static Queue<Integer> startNode;
	private static List<Integer>[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			inDegree = new int[n+1];
			times = new int[n+1];
			sum = new int[n+1];
			parents = new List[n+1];
			
			for (int i = 0; i < n+1; i++) {
				parents[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n+1; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				parents[from].add(to);//from -> to
				inDegree[to]++;
			}
			
			w = Integer.parseInt(br.readLine());
			
			startNode = new LinkedList<>();
			findStartNode();
			
			constructBuildings();
			sb.append(sum[w] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void findStartNode() {
		for (int i = 1; i < n+1; i++) {
			if (inDegree[i] == 0) {
				startNode.offer(i);
				sum[i] = times[i];
			}
		}
	}
	
	public static void constructBuildings() {
		while(!startNode.isEmpty()) {
			int node = startNode.poll();
			
			for (int parent : parents[node]) {
				sum[parent] = Math.max(sum[parent], sum[node] + times[parent]);
				inDegree[parent]--;
				
				if (inDegree[parent] == 0) {
					startNode.offer(parent);
				}
			}
		}
	}
}
