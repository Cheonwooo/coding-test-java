package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * dp 문제
 * 마지막 자릿수에 0이 오는건 dp[][1]만 가능
 * 마지막 자릿수에 9가 오는건 dp[][8]만 가능
 * 그외에는 dp[][n+1], dp[][n-1] 가능
 * 이중 for문 이용, 2~100자릿수 까지 for문 + 마지막에 올 수 있는 수 0~9까지 for문
 * 
 * 시간복잡도
 * 99 * 10
 * 
 * 자료구조
 * dp를 저장할 long[][]
 * 정답을 저장할 long
 */

public class Ex10844 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[101][10];
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i < 101; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][1] % 1_000_000_000;
				} else if (j == 9) {
					dp[i][j] = dp[i-1][8] % 1_000_000_000;
				} else {
					dp[i][j]= (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
				}
			}
		}
		long result = 0;
		
		for (int i = 0; i < 10; i++) {
			result += dp[n][i];
		}
		System.out.println(result % 1_000_000_000);
	}
}
