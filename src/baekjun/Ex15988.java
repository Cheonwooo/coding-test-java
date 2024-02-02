package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * An = An-1 + An-2 + An-3 
 * 
 * 시간복잡도
 * n
 * 
 * 자료구조
 * dp값 저장할 int[]
 * 정답을 저장할 int
 */

public class Ex15988 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < 1000001; i++){
			dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1_000_000_009; 
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}

}
