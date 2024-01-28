package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp 이용
 * d[n] = p[i] + d[n-i]
 * d[n], p[i] + d[n-1] 중 최솟값 구하기
 * 
 * 시간복잡도 
 * n * p
 * 
 * 자료구조
 * dp값 저장할 int[]
 * 카드값 저장할 int[]
 * 정답 저장할 int
 */

public class Ex16194 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cardPrice = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			cardPrice[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], cardPrice[j] + dp[i-j]);
			}
		}
		
		int answer = dp[n];
		System.out.println(answer);
	}
}
