package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵��
 * dp ����
 * ������ �ڸ����� 0�� ���°� dp[][1]�� ����
 * ������ �ڸ����� 9�� ���°� dp[][8]�� ����
 * �׿ܿ��� dp[][n+1], dp[][n-1] ����
 * ���� for�� �̿�, 2~100�ڸ��� ���� for�� + �������� �� �� �ִ� �� 0~9���� for��
 * 
 * �ð����⵵
 * 99 * 10
 * 
 * �ڷᱸ��
 * dp�� ������ long[][]
 * ������ ������ long
 */

public class Ex10844 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[101][10];
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i < 101; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][1] % 1_000_000_000;
				} else if (j == 9) {
					dp[i][j] = dp[i-1][8] % 1_000_000_000;
				} else {
					dp[i][j]= (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
				}
			}
		}
		long result = 0;
		
		for (int i = 0; i < 10; i++) {
			result += dp[n][i];
		}
		System.out.println(result % 1_000_000_000);
	}
}
