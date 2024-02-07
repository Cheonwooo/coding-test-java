package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp이용
 * 가장 긴 증가하는 부분 수열을 거꾸로 하는 것과 같음
 * 2중 for문 사용 - n-1부터 0까지 for문, i부터 n-1까지 for문
 * 
 * 시간복잡도
 * n * n
 * 
 * 자료구조
 * 입력값을 받을 int[]
 * dp값을 입력할 int[]
 * 정답을 저장할 int
 */

public class Ex11722 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		int max = 1;
		dp[n] = 1;
		for (int i = n-1; i >= 1; i--) {
			dp[i] = 1;
			for (int j = i+1; j < n+1; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}

}
