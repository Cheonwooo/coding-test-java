package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14889_2 {
	private static int n, min;
	private static int[] temp;
	private static int[][] stats;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		stats = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		temp = new int[n/2];
		visited = new boolean[n];
		dfs(0, 0);
		System.out.println(min);
	}
	
	public static void dfs(int depth, int start) {
		if (depth == n/2) {
			min = Math.min(min, makeMinAbs(temp));
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				dfs(depth+1, i);
				visited[i] = false;
			}
		}
	}
	
	public static int makeMinAbs(int[] temp) {
		int[] exceptTemp = new int[n/2];
		
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				exceptTemp[index] = i;
				index++;
			}
		}
		
		int startSum = calculateSum(temp);
		int linkSum = calculateSum(exceptTemp);
		
		return (int)Math.abs(startSum - linkSum);
	}
	
	public static int calculateSum(int[] arr) {
		int sum = 0;
		
		for (int i = 0; i < n/2; i++) {
			for (int j = i+1; j < n/2; j++) {
				sum += stats[arr[i]][arr[j]] + stats[arr[j]][arr[i]];
			}
		}
		return sum;
	}
}
