package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 14236kb, 시간 104ms

public class Ex16565 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] comb = new int[53][53];
		
		for (int i =0 ; i <= 52; i++) {
			comb[i][0] = 1;
		}
		
		for (int i = 1; i <= 52; i++) {
			for (int j = 1; j <= 52; j++) {
				 comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % 10007;
			} 
		}
		
		int answer = 0;
		for (int i = 1; i <= 13 && n-4*i >= 0; i++) {
			if (i % 2 == 1) {
				answer = (answer + comb[13][i]*comb[52-4*i][n-4*i]) % 10007;
			} else {
				answer = (answer - (comb[13][i]*comb[52-4*i][n-4*i]) % 10007 + 10007) % 10007;
			}
		}
		
		System.out.println(answer);
	}
}
