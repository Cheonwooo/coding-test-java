package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex14002_4 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1);
		
		int max = 1;
		int index = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = i-1; j >= 1; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				} else if (arr[i] == arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
				
				if (dp[i] > max) {
					max = dp[i];
					index = i;
				}
			}
		}	
		
		sb.append(max).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[index]);
		
		while (max > 1) {
			for (int i = index-1; i >= 1; i--) {
				if (dp[i] == (max-1)) {
					stack.push(arr[i]);
					max--;
				}
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}
