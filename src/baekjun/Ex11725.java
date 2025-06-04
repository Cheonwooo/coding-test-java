package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex11725 {

	private static boolean[] visited;
	private static int[] parent;
	private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		parent = new int[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		dfs(1);
		
		for (int i = 2; i < n+1; i++) {
			System.out.println(parent[i]);
		}
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		
		for (int next : list.get(start)) {
			if (!visited[next]) {
				dfs(next);
				parent[next] = start;
			}
		}
	}

}
