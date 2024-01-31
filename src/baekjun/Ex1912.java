package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 :
 * dp이용
 * List에 값 저장
 * 이전의 인덱스까지의 합과 현재 인덱스 값중 큰 값을 dp에 저장
 * 
 * 시간복잡도
 * 
 * 
 * 자료구조
 * dp값을 저장할 int[]
 * 입력값을 저장할 int[]
 * 정답을 저장할 int
 */

public class Ex1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int max = arr[0];
		
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}

}
