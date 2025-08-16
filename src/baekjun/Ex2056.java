package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2056 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cost = new int[n];
		int[] sum = new int[n];
		int[] inDegree = new int[n];
		boolean[] isDuplicated = new boolean[n];
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			cost[i] = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < m; j++) {
				int pre = Integer.parseInt(st.nextToken())-1;
				
				graph[pre].add(i);
				inDegree[i]++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
				sum[i] = cost[i];
			}
		}
		
		while (!q.isEmpty()) {
			int from = q.poll();
			
			for (int i = 0; i < graph[from].size(); i++) {
				int to = graph[from].get(i);
				sum[to] = Math.max(sum[to], sum[from] + cost[to]);
				inDegree[to]--;
				
				if (inDegree[to] == 0) {
					q.offer(to);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, sum[i]);
		}
		System.out.println(answer);
	}

}
