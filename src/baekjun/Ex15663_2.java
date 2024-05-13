package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex15663_2 {
	private static int N, M;
	private static int[] arr, temp;
	private static boolean[] visited;
	private static Set<String> set = new LinkedHashSet<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		temp = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		for (String answer : set) {
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if (depth == M) {
			String str = "";
			for (int val : temp) {
				str += String.valueOf(val) + " ";
			}
			set.add(str);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = arr[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}

}
