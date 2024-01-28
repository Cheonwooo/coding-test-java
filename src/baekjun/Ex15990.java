package baekjun;

/*
 * 아이디어
 * 링크 : https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-15990-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-5-Java
 * 손으로 경우의 수를 모두 만들어봐야함
 * 
 * 시간복잡도
 * n
 * 
 * 자료구조
 * 각 자릿수 경우의 수를 저장할 long[][]
 * dp를 저장할 long[]
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15990 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];
		long[] answer = new long[100001];
		
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for (int i = 4; i < 100001; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
		}
		
		for (int i = 1; i < 100001; i++) {
			answer[i] = (dp[i][1] + dp[i][2] + dp[i][3]) % 1_000_000_009;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			
			sb.append(answer[number]).append("\n");
		}
		System.out.println(sb);
	}
}
