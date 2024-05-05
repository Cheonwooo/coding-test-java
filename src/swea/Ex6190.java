package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex6190 {
	private static int n, max;
	private static int[] temp, arr; 
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			temp = new int[2];
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			visited = new boolean[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			dfs(0, 0);
			
			if (max == Integer.MIN_VALUE) {
				max = -1;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int start) {
		if (depth == 2) {
			int sum = 1;
			for (int val : temp) {
				sum *= val;
			}
			
			if(checkUptoNumber(sum)) {
				max = Math.max(max, sum);
			}
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = arr[i];
				dfs(depth+1, i);
				visited[i] = false;
			}
		}
	}
	
	public static boolean checkUptoNumber(int sum) {
		String number = String.valueOf(sum);
		
		boolean isUptoNumber = false;
		for (int i = 0; i < number.length()-1; i++) {
			if ((int)number.charAt(i) <= (int)number.charAt(i+1)) {
				continue;
			}
			isUptoNumber = true;//증가함수가 아님
			break;
		}
		if (isUptoNumber) return false;
		return true;
	}
}
