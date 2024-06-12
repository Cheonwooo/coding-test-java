package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15652_4 {
	private static int n, m;
	private static int[] temp;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		temp = new int[m];
		
		comb(0, 0);
		System.out.println(sb);
	}

	public static void comb(int start, int depth) {
		if (depth == m) {
			for (int val : temp) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < n; i++) {
			temp[depth] = i+1;
			comb(i, depth+1);
		}
	}
}
