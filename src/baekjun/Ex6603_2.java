package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex6603_2 {
	private static int n;
	private static int[] inputs, arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer  st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			
			if (n == 0) break;
			
			arr = new int[6];
			inputs = new int[n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int start, int depth) {
		if (depth == 6) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = inputs[i];
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
}
