package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10971_3 {
	
	private static int n, min;
	private static int[] temp;
	private static int[][] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		min = Integer.MAX_VALUE;
		visited = new boolean[n];
		temp = new int[n+1];
		perm(0);
		System.out.println(min);
	}

	public static void perm(int depth) {
		if (depth == n) {
			temp[n] = temp[0];
			calculateDistance(temp);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				perm(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void calculateDistance(int[] temp) {
		int sum = 0;
		for (int i = 0; i < temp.length-1; i++) {
			if (arr[temp[i]][temp[i+1]] == 0) return;
			sum += arr[temp[i]][temp[i+1]];
		}
		min = Math.min(min, sum);
	}
}
