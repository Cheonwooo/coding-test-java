package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14888 {
	private static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	private static int[] arr, signs, temp;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int[] signNumbers = new int[4]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			signNumbers[i] = Integer.parseInt(st.nextToken());
		}
		
		signs = new int[n-1];
		temp = new int[n-1];
		visited = new boolean[n-1];
		int index = 0;
		for (int i = 0; i < n-1;) {
			if (signNumbers[index] != 0) {
				signs[i] = index;
				signNumbers[index]--;
				i++;
			} else {
				index++;
			}
		}
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int depth) {
		if (depth == n-1) {
			int number = calculateSigns(temp);
			
			max = Math.max(max, number);
			min = Math.min(min, number);
			return;
		}
		
		for (int i = 0; i < n-1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = signs[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static int calculateSigns(int[] temp) {
		int sum = arr[0];
		
		int index = 1;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0) {
				sum += arr[index];
			} else if (temp[i] == 1) {
				sum -= arr[index];
			} else if (temp[i] == 2) { 
				sum *= arr[index];
			} else {
				if (sum < 0) {
					sum *= -1;
					sum /= arr[index];
					sum *= -1;
				} else {
					sum /= arr[index];
				}
			}
			index++;
		}
		
		return sum;
	}
}
