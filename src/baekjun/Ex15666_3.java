package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex15666_3 {
	private static int n, m;
	private static int[] arr, temp;
	private static Set<String> set = new LinkedHashSet<>();

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
		for (String answer : set) {
			System.out.println(answer);
		}
	}
	
	public static void dfs(int start, int depth) {
		if (depth == m) {
			String str = "";
			for (int val : temp) {
				str += String.valueOf(val) + " ";
			}
			set.add(str.trim());
			return;
		}
		
		for (int i = start; i < n; i++) {
			temp[depth] = arr[i];
			dfs(i, depth+1);
		}
	}
}
