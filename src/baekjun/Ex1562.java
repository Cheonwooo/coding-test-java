package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리 20552kb, 시간 120ms

public class Ex1562 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][][] dp = new long[n+1][10][1<<10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i][1<<i] = 1;
		}
		
		for (int i = 2; i < n+1; i++) {
			for (int j =0 ; j < 10; j++) {
				for (int k = 0 ; k < 1024; k++) {
					int bit = k | (1 << j);
					if (j == 0) {
						dp[i][j][bit] += dp[i-1][j+1][k] % 1_000_000_000;
					} else if (j == 9) {
						dp[i][j][bit] += dp[i-1][j-1][k] % 1_000_000_000;
					} else {
						dp[i][j][bit] += (dp[i-1][j-1][k] + dp[i-1][j+1][k]) % 1_000_000_000;
					}
				}
			}
		}
		
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i][1023] % 1_000_000_000;
		}
		System.out.println(sum % 1_000_000_000);
	}

}
