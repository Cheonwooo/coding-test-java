package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10819 {
	private static int n, max;
	private static int[] inputs, arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		inputs = new int[n];
		arr = new int[n];
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		perm(0);
		System.out.println(max);
	}
	
	private static void perm(int depth) {
		if (depth == n) {
			
			int sum = 0;
			for (int i = 1; i < n; i++) {
				sum += (int)Math.abs(arr[i-1]-arr[i]);
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = inputs[i];
				perm(depth+1);
				visited[i] = false;
			}
		}
	}

}
