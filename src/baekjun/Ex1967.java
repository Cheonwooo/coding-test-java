package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1967 {
	
	private static int max = 0;
	private static boolean[] visited;
	private static List<int[]>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[from].add(new int[] {to, price});
			list[to].add(new int[] {from, price});
		}
		
		for (int i = 1; i < n+1; i++) {
			visited = new boolean[n+1];
			dfs(i, 0);
		}
		System.out.println(max);
	}
	
	private static void dfs(int start, int dis) {
		visited[start] = true;
		max = Math.max(max, dis);
		
		for (int[] node : list[start]) {
			if (!visited[node[0]]) {
				visited[node[0]] = true;
				dfs(node[0], dis + node[1]);
			}
		}
	}
}