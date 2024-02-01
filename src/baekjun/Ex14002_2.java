package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex14002_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] index = new int[n+1];
		int[] dp = new int[n+1];
		
		int max = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			index[i] = Integer.parseInt(st.nextToken());
			
			for (int j = i; j >= 0; j--) {
				if (index[i] > index[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n+1; i++) {
			if (index[i] == max) {
				stack.push(index[i]);
				max--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
		
	}

}


