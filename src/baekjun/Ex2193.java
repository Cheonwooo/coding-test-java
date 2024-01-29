package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵��
 * dp �̿�
 * ���ڸ��� 1�� ��� �ڿ� 0�� ����
 * ���ڸ��� 0�� ��� �ڿ� 0, 1 ����
 * A[i][0] = A[i-1][0] + A[i-1][1]
 * A[i][1] = A[i-1][0]
 * 2�� for�� - 1���� 90���� for���� �̿�, 0��1�� �ݺ��ϴ� for��
 * �ڸ������� dp[i] = A[i][0] + A[i][1]
 * 
 * �ð����⵵
 * n * 2
 * 
 * �ڷᱸ��
 * ��ģ���� ������ ������ int[][]
 * dp���� ������ int[]
 * ������ ������ int
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
