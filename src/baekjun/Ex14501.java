package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * dp활용
 * 배열의 뒤부터 dp값 저장하기
 * dp[i]의 의미는 i일'부터' 상담을 시작했을 때의 최댓값
 * dp[i] = dp[i+Ti]부터 dp[n]까지의 최댓값 + i번째 상담금액
 *  
 * 시간복잡도
 * n * (n-1)
 * 
 * 자료구조
 * dp값을 저장할 int[]
 * 입력값을 저장할 int[][]
 *  -int[][0] = Ti
 *  -int[][1] = Pi
 */

public class Ex14501 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+2];
		int[][] callBack = new int[n+1][2];
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			callBack[i][0] = Integer.parseInt(st.nextToken());
			callBack[i][1] = Integer.parseInt(st.nextToken());
			
			for (int j = i+callBack[i][0]; j < n+2; j++) {
				dp[j] = Math.max(dp[j], callBack[i][1] + dp[i]);
			}
		}
		
		
		int max = 0;
		for (int i = 1; i < n+2; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
