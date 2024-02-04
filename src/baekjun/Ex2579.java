package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵��
 * n��° ����� ������ ����� 2����
 * n-2��° ��ܿ��� �ٷ� ���� ���
 * n-3, n-1��° ����� ���ؼ� ���� ���
 * dp[n] = max(dp[n-3] + arr[n-1], dp[n-2]) + arr[n]
 * dp[1~3]������ �� ���� �����ϱ�
 * for�� 1�� ���
 * 
 * �ð����⵵
 * 300
 * 
 * �ڷᱸ��
 * dp���� ������ int[]
 */

public class Ex2579 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[301];
		int[] stair = new int[301];
		
		for (int i = 1; i < n+1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		dp[3] = Math.max(stair[1], stair[2]) + stair[3];

		for (int i = 4; i < n+1; i++) {
			dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
		}
		
		System.out.println(dp[n]);
	}

}
