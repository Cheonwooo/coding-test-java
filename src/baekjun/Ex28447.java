package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex28447 {
	
	private static int n, answer = -10_000_000;
	private static int[] temp;
	private static int[][] arr;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		temp = new int[k];
		visited = new boolean[n];
		
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, k);
		System.out.println(answer);
	}

	private static void comb(int depth, int r) {
		if (depth == r) {
			int sum = calculateSum();
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				comb(depth + 1, r);
				visited[i] = false;
			}
		}
	}
	
	private static int calculateSum() {
		int sum = 0;
		for (int i = 0; i < temp.length-1; i++) {
			for (int j = i+1; j < temp.length; j++) {
				sum += arr[temp[i]][temp[j]];
			}
		}
		return sum;
	}
}
