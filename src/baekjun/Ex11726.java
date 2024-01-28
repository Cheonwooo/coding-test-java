package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * 점화식 : An = An-1 + An-2
 * 점화식을 구하기 위해 for문 돌면서 dp값 저장
 * n까지 dp값 저장 후 10007로 나누기
 * 
 * 시간복잡도 : n(for문 1번 돎)
 * 
 * 자료구조
 * dp값 저장할 int[]
 * 나머지 저장할 int
 */

public class Ex11726 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
			
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
			
		int answer = dp[n] % 10007;
		System.out.println(answer);
	}
}
