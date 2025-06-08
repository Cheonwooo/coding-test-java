package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9251 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String wordA = br.readLine();
		String wordB = br.readLine();
		
		int[][] dp = new int[wordA.length() + 1][wordB.length() + 1];
		
		for (int i = 1; i < wordA.length() + 1; i++) {
			for (int j = 1; j < wordB.length() + 1; j++) {
				if (wordA.charAt(i-1) == wordB.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[wordA.length()][wordB.length()]);
	}
}
