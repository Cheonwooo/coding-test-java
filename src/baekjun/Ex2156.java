package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * dp이용
 * 2579 계단 오르기 문제와 같은 유형
 * n번째에 올 수 있는 포도주의 양은 n-3번쨰 최댓값과 n-1번째값의 합과 n-2번째 최댓값 중 최댓값
 * dp[n] = max(dp[n-3] + wine[n-1], dp[n-2]) + wine[n];
 * dp[1][2][3]값은 지정
 * for문 한번 사용
 * 
 * 시간복잡도
 * n
 * 
 * 자료구조
 * 입력값을 저장할 int[] 
 * dp값을 저장할 int[]
 * 
 */

public class Ex2156 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[10001];
		int[] dp = new int[10001];
		
		for (int i = 1; i < n+1; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		
		for (int i = 3; i < n+1; i++) {
			dp[i] = Math.max((Math.max(dp[i-3] + wine[i-1], dp[i-2]) + wine[i]), dp[i-1]);
		}
		System.out.println(dp[n]);
	}
}
