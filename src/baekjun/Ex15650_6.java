package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15650_6 {
	
	private static int n, m;
	private static int[] temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		temp = new int[m];
		
		dfs(0, 0);
	}

	private static void dfs(int depth, int start) {
		if (depth == m) {
			for (int val : temp) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < n; i++) {
			temp[depth] = i+1;
			dfs(depth+1, i+1);
		}
	}
}
