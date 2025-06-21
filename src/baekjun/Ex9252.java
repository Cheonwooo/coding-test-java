package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex9252 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		
		for (int i = 1; i < str1.length() + 1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int len1 = str1.length();
		int len2 = str2.length();
		Stack<String> stack = new Stack<>();
		while (len1 > 0 && len2 > 0) {
			if (dp[len1][len2] == dp[len1-1][len2]) {
				len1--;
			} else if (dp[len1][len2] == dp[len1][len2-1]) {
				len2--;
			} else {
				len1--;
				len2--;
				stack.push(String.valueOf(str1.charAt(len1)));
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(dp[str1.length()][str2.length()]);
		System.out.println(sb);
	}
}


