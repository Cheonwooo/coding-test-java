package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex2814 {
	private static int max;
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t+ " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if (m == 0) {
				sb.append("1").append("\n");
				continue;
			}
			
			list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			
			
			max = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				visited = new boolean[n+1];
				visited[i] = true;
				
				dfs(i, 1);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int start, int count) {
		max = Math.max(max, count);
		
		for (int i = 0; i < list.get(start).size(); i++) {
			int nextEdge = list.get(start).get(i);
			
			if (!visited[nextEdge]) {
				visited[nextEdge] = true;
				dfs(nextEdge, count+1);
				visited[nextEdge] = false;
			}
		}
	}
}
