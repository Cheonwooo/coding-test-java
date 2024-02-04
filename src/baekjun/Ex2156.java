package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵��
 * dp�̿�
 * 2579 ��� ������ ������ ���� ����
 * n��°�� �� �� �ִ� �������� ���� n-3���� �ִ񰪰� n-1��°���� �հ� n-2��° �ִ� �� �ִ�
 * dp[n] = max(dp[n-3] + wine[n-1], dp[n-2]) + wine[n];
 * dp[1][2][3]���� ����
 * for�� �ѹ� ���
 * 
 * �ð����⵵
 * n
 * 
 * �ڷᱸ��
 * �Է°��� ������ int[] 
 * dp���� ������ int[]
 * 
 */

public class Ex2156 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[10001];
		int[] dp = new int[10001];
		
		for (int i = 1; i < n+1; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = wine[1];
		dp[2] = wine[1] + wine[2];
		
		for (int i = 3; i < n+1; i++) {
			dp[i] = Math.max((Math.max(dp[i-3] + wine[i-1], dp[i-2]) + wine[i]), dp[i-1]);
		}
		System.out.println(dp[n]);
	}
}
