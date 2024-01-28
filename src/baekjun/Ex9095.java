package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * An = An-3 + An-2 + An-1
 * for문 돌면서 값 저장
 * 
 * 시간복잡도
 * n
 * 
 * 자료구조
 * dp 저장할 int[]
 * 정답 저장할 int
 */

public class Ex9095 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[12];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < 12; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			
			sb.append(dp[number]).append("\n");
		}
		System.out.println(sb);
	}
}
