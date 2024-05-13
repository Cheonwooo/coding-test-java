package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2817 {
	private static int N, K, count;
	private static int[] arr, temp;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { 
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			for (int i = 1; i <= N; i++) {
				temp = new int[i];
				visited = new boolean[N];
				comb(0, 0, i);
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	public static void comb(int start, int depth, int r) {
		if (depth == r) {
			int sum = 0;
			for (int val : temp) {
				sum += val;
			}
			if (sum == K) count++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = arr[i];
				comb(i+1, depth+1, r);
				visited[i] = false;
			}
		}
	}
}
