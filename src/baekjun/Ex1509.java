package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 메모리 36580kb, 시간 176ms

public class Ex1509 {
	
	private static int size;
	private static int[] memorize;
	private static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		size = word.length();
		memorize = new int[size];
		dp = new int[size][size];
		
		Arrays.fill(memorize, 2501);
		
		palindrome(word);
		
		for (int i = 0; i < size; i++) {
			if (dp[0][i] == 1) {
				memorize[i] = 1;
			} else {
				for (int j = 1; j <= i; j++) {
					if (dp[j][i] == 1) {
						memorize[i] = Math.min(memorize[i], memorize[j-1]+1);
					}
				}
			}
		}
		System.out.println(memorize[size-1]);
	}

	public static void palindrome(String word) {
		for (int i = 0; i < size; i++) {
			dp[i][i] = 1;
		}
		
		for (int i = 0; i < size-1; i++) {
			if (word.charAt(i) == word.charAt(i+1)) {
				dp[i][i+1] = 1;
			}
		}
		
		for (int i = 2; i < size; i++) {
			for (int j = 0; j+i < size; j++) {
				if (word.charAt(j) == word.charAt(j+i) &&
						dp[j+1][j+i-1] == 1) {
					dp[j][j+i] = 1;
				}
					
					
			}
		}
	}
}
