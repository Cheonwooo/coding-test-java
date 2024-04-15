package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2529 {
	private static int n;
	private static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
	private static int[] arr;
	private static String[] sign;
	private static boolean[] visited = new boolean[10];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		sign = new String[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < sign.length; i++) {
			sign[i] = st.nextToken();
		}
		
		dfs(0);
		
		System.out.println(String.format("%0" + (n+1) + "d", max));
		System.out.println(String.format("%0" + (n+1) + "d", min));
	}
	
	public static void dfs(int depth) {
		if (depth == n+1) {
			
			if (isValid()) {
				long newNumber = calculateNumber();
				
				max = Math.max(max, newNumber);
				min = Math.min(min, newNumber);
			}
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isValid() {
		for (int i = 0; i < n; i++) {
			if (sign[i].equals("<") && arr[i] > arr[i+1]) {
				return false;
			}
			if (sign[i].equals(">") && arr[i] < arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static long calculateNumber() {
		long sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum = sum * 10 + arr[i];
		}
		
		return sum;
	}
}
