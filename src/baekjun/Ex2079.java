package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 메모리 29972kb, 시간 172ms

public class Ex2079 {
	
	private static int size, min = Integer.MAX_VALUE;
	private static int[] memorize;
	private static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		size = word.length();
		dp = new int[size][size];
		memorize = new int[size];
		
		Arrays.fill(memorize, 2001);
		memorize[0] = 0;
		
		palidrome(word);
		
		for(int j = 0; j < size; j++) {
            if(dp[0][j] == 1) {
                memorize[j] = 1;
            } else{
                for(int i = 1; i <= j; i++) {
                    if(dp[i][j] == 1) {
                        memorize[j] = Math.min(memorize[j], memorize[i-1] + 1);
                    }
                }
            }
        }
		System.out.println(memorize[size-1]);
	}

	public static void palidrome(String word) {
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
