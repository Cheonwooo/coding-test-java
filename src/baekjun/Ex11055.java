package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp이용
 * n번째 최댓값은 n-1부터 1까지 n번째 수보다 작은 수 중 최댓값과 더하기
 * dp[n] = dp[n-1-n] + arr[n]
 * 
 * 시간복잡도
 * n * n = n^2
 * 
 * 자료구조
 * 입력값을 저장할 int[]
 * dp값을 저장할 int[]
 */

public class Ex11055 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		for (int i = 2; i < n+1; i++) {
			dp[i] = arr[i];
			for (int j = i-1; j >= 1; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i < n+1; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
