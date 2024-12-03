package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15651_6 {
	
	private static int n, m;
	private static int[] temp;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		temp = new int[m];
		
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if (depth == m) {
			for (int val : temp) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			temp[depth] = i+1;
			dfs(depth+1);
		}
	}
}
