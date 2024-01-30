package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp
 * n번째까지 가장 긴 부분 수열은 (n-1번째+1) 와 n번째를 비교
 * 이중 for문, 1~n까지 for문, 첫번째 for문의 인덱스 값부터 0까지 for문
 *  
 * 
 * 시간복잡도 : 1000
 */

public class Ex14002 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] index = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int maxLength = 0;
		for (int i = 1; i < n+1; i++) {
			index[i] = Integer.parseInt(st.nextToken());
			
			for (int j = i-1; j >= 0; j--) {
				if (index[i] > index[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					maxLength = Math.max(dp[i], maxLength);
				}
			}
		}
		System.out.println(maxLength);
		
		Stack<Integer> stack = new Stack<>();
		for (int i = n; i >= 1; i--) {
			if (maxLength == dp[i]) {
				stack.push(index[i]);
				maxLength--;
			}
			if (maxLength == 0) break;
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
}
