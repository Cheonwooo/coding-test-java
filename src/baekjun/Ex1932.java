package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * dp�̿�
 * dp[n][1] += dp[n-1][1]
 * dp[n][k] += dp[n-1][k-1]
 * dp[n][i] = max(dp[n-1][i-1], dp[n-1][i]) + arr[n][i]
 * 2�� for�� �̿� i�� 3���� n���� for��, 2���� i���� for��
 * 
 * 
 * �ð����⵵
 * n * (n*(n+1))/2 = n^3
 * 
 * �ڷᱸ��
 * �Է°��� ������ int[][]
 * dp���� ������ int[][]
 */

public class Ex1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[501][501];
		int[][] dp = new int[501][501];
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = arr[1][1];
		for (int i = 2; i < n+1; i++) {
			dp[i][1] = dp[i-1][1] + arr[i][1];
			dp[i][i] = dp[i-1][i-1] + arr[i][i];
		}

		for (int i = 3; i < n+1; i++) {
			for (int j = 2; j < i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
		int max = 0;
		for (int i = 0; i < n+1; i++) {
			max = Math.max(max, dp[n][i]);
		}
		System.out.println(max);
	}

}
