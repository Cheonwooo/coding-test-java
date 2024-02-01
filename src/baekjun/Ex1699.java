package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * dp이용
 * 13의 제곱수 합 최소항의 개수는
 * (13-1)의 최소항의 개수 + 1
 * (13-4)의 최소항의 개수 + 1
 * (13-9)의 최소항의 개수 + 1 중 최솟값이다. +1해주는 이유는 1=1*1, 4=2*2, 9=3*3
 * 
 * 시간복잡도 
 * (sqrt(n)+(sqrt(n)))/2
 * 
 * 자료구조
 * dp값을 저장할 int[]
 * 정답을 저장할 int
 */

public class Ex1699 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		for (int i = 1; i < n+1; i++) {
			dp[i] = i;
			for (int j = 1; j*j <= i; j++) {
				if (dp[i] > dp[i - j*j] + 1) {
					dp[i] = dp[i - j*j] + 1;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
