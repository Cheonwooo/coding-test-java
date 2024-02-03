package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * d[1] 
 * 00 01 10
 * d[2]
 * 00 00 00 01 01 10 10
 * 00 01 10 00 10 00 01
 * arr[n][0]==0&&arr[n][1]==0이면 +3
 * 아닌 경우 +2
 * 
 * 이전 값에서 만들 수 있는 총 경우의 수
 * d[n-1] * 3
 * 여기서 마지막 값이 00이 아닌 값들의 개수는 
 * d[n-1] - d[n-2]
 * 따라서 d[n] = d[n-1]*3 - (d[n-1] - d[n-2]) 
 * d[1] = 3
 * d[2] = 3*3 - 2= 7
 * d[3] = 7*3 - 4 = 17
 * d[4] = 17*3 - 10 = 41
 * 
 * 시간복잡도 
 * n
 * 
 * 자료구조
 * dp값을 저장할 int[]
 * 정답을 저장할 int
 */

public class Ex1309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		
		dp[1] = 3;
		dp[2] = 7;
		
		for (int i = 3; i < 100001; i++) {
			dp[i] = (dp[i-1]*3 - (dp[i-1] - dp[i-2])) % 9901;
		}
		System.out.println(dp[n] % 9901);
	}

}
