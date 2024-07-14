package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex15666_4 {
	private static int n, m;
	private static int[] arr, temp;
	private static Set<String> set = new LinkedHashSet<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		temp = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
		if (depth == m) {
			for (int val : temp) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		int num = 0;
		for (int i = start; i < n; i++) {
			if (num == arr[i]) continue;
			temp[depth] = arr[i];
			dfs(i, depth+1);
			num = arr[i];
		}
	}
}
