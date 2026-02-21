package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex16238 {

	private static final long INF = Long.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long[] dp = new long[n+1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		long answer = 0;
		
		for (int i = 1; i < n+1; i++) {
			for (int j = i; j >= 1; j--) {
				if (dp[j-1] == INF) continue;
				
				long lose = j - 1;
				long gain = arr[i] - lose;
				if (gain < 0) gain = 0;
				
				dp[j] = Math.max(dp[j], dp[j-1] + gain);
			}
		}
		
		for (int i = 0; i < n+1; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}

/**
 * 가장 많은 양의 칸을 어떻게 찾을까?
 * 매번 반복문 돌리면 시초
 * 정렬? 근데 정렬하면 지나간 칸의 양 초기화를 할 수 없음.
 * 객체로 만들어서 정렬 조건을 둔다? ㅇ이것도 지나간 칸의 양 초기화가 어려움
 */
