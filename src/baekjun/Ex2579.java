package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * n번째 계단을 오르는 방법은 2가지
 * n-2번째 계단에서 바로 오는 방법
 * n-3, n-1번째 계단을 통해서 오는 방법
 * dp[n] = max(dp[n-3] + arr[n-1], dp[n-2]) + arr[n]
 * dp[1~3]까지는 값 직접 대입하기
 * for문 1번 사용
 * 
 * 시간복잡도
 * 300
 * 
 * 자료구조
 * dp값을 저장할 int[]
 */

public class Ex2579 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[301];
		int[] stair = new int[301];
		
		for (int i = 1; i < n+1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		dp[3] = Math.max(stair[1], stair[2]) + stair[3];

		for (int i = 4; i < n+1; i++) {
			dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
		}
		
		System.out.println(dp[n]);
	}

}
