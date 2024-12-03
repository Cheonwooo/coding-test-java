package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 메모리 93300kb, 시간 640ms

public class Ex1167 {
	
	private static int node, max = Integer.MIN_VALUE;
	private static boolean[] visited;
	private static List<int[]>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				
				if (to == -1) break;
				
				int dis = Integer.parseInt(st.nextToken());
				
				list[start].add(new int[] {to, dis});
			}
		}
		
		visited = new boolean[n+1];
		dfs(1, 0);
		
		visited = new boolean[n+1];
		dfs(node, 0);
		
		System.out.println(max);
	}

	private static void dfs(int start, int price) {
		if (price > max) {
			max = price;
			node = start;
		}
		
		visited[start] = true;

		for (int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i)[0];
			
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, price + list[start].get(i)[1]);
			}
		}
	}
}
