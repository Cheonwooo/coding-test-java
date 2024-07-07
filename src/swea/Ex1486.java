package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1486 {
	private static int n, b, answer;
	private static int[] arr, temp;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				temp = new int[i];
				visited = new boolean[n];
				dfs(0, 0, i);
			}
			sb.append(answer-b).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth, int r) {
		if (depth == r) {
			int sum = calculateHeight(temp);
			if (b <= sum) {
				answer = Math.min(answer, sum);
			}
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = arr[i];
				dfs(i+1, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
	public static int calculateHeight(int[] temp) {
		int sum = 0;
		for (int val : temp) {
			sum += val;
		}
		return sum;
	}
}
