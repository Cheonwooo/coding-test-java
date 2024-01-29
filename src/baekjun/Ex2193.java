package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * dp 이용
 * 끝자리가 1인 경우 뒤에 0만 가능
 * 끝자리가 0인 경우 뒤에 0, 1 가능
 * A[i][0] = A[i-1][0] + A[i-1][1]
 * A[i][1] = A[i-1][0]
 * 2중 for문 - 1부터 90까지 for문을 이용, 0과1을 반복하는 for문
 * 자릿수마다 dp[i] = A[i][0] + A[i][1]
 * 
 * 시간복잡도
 * n * 2
 * 
 * 자료구조
 * 이친수의 개수를 저장할 int[][]
 * dp값을 저장할 int[]
 * 정답을 저장할 int
 * 
 */

public class Ex2193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][] pinary = new long[91][2];
		long[] dp = new long[91];
		
		pinary[1][0] = 1;
		pinary[2][0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			for (int j = 0; j <=1; j++) {
				if (j == 0) {
					pinary[i][j] = pinary[i-1][0] + pinary[i-1][1];
				} else {
					pinary[i][j] = pinary[i-1][0];
				}
			}
			
			dp[i] = pinary[i][0] + pinary[i][1];
		}
		
		System.out.println(dp[n]);
	}

}
