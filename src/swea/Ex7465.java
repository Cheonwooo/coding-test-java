package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex7465 {
	private static int[] parents;
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			visited = new boolean[n+1];
			
			for (int i = 1; i <= n; i++) {
				visited[i] = true;
				parents[i] = i;
			}
			
			list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				unionParent(a, b);
			}
			
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				if (visited[i]) answer++;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) {
			parents[b] = a;
			visited[b] = false;
		}
		else if (a > b) {
			parents[a] = b;
			visited[a] = false;
		}
	}
	
	public static int findParent(int a) {
		if (parents[a] == a) return parents[a];
		else return parents[a] = findParent(parents[a]);
	}
}
