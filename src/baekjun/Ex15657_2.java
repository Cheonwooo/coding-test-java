package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex15657_2 {
	private static int N, M;
	private static int[] arr, temp;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		temp = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
		if (depth == M) {
			for (int val : temp) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			temp[depth] = arr[i];
			dfs(i, depth+1);
		}
	}

}
