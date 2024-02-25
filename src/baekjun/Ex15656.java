package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex15656 {
	private static int n, m;
	private static int[] inputs, arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		inputs = new int[n];
		visited = new boolean[n];
		arr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputs);
		
		dfs(0);
		System.out.println(sb);
	}
	
	private static void dfs(int depth) {
		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[depth] = inputs[i];
			dfs(depth+1);
		}
	}

}
