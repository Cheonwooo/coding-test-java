package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp이용
 * d[n] = p[i] + d[n-i]
 * d[n]과 d[n-i] + p[i] 중 최댓값
 * 
 * 시간복잡도
 * n * p
 * 
 * 자료구조
 * dp값을 저장할 int[]
 * 카드 값을 저장할 int[]
 * 
 */

public class Ex11052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cardPrice = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			cardPrice[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + cardPrice[j]);
			}
		}
		
		int answer = dp[n];
		System.out.println(answer);
	}

}
