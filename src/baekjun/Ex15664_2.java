package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex15664_2 {
	private static int n, m;
	private static int[] arr, temp;
	private static StringBuilder sb = new StringBuilder();
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
		comb(0, 0);
		for (String answer : set) {
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void comb(int start, int depth) {
		if (depth == m) {
			String str = "";
			for (int val : temp) {
				str += String.valueOf(val) + " ";
			}
			set.add(str);
			return;
		}
		
		for (int i = start; i < n ; i++) {
			temp[depth] = arr[i];
			comb(i+1, depth+1);
		}
	}
}
