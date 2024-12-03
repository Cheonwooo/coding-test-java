package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex15664_4 {
	
	private static int n, m;
	private static int[] arr, temp;
	private static Set<String> answer = new LinkedHashSet<>();
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
		for (String str : answer) {
			sb.append(str + "\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int depth, int start) { 
		if(depth == m) {
			String str = "";
			for (int val : temp) {
				str += val + " ";
			}
			answer.add(str);
			return;
		}
		
		for (int i = start; i < n; i++) {
			temp[depth] = arr[i];
			dfs(depth+1, i+1);
		}
		
	}

}
