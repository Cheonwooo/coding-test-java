package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * dp�̿�
 * �� �ึ�� ������ �� �ִ� ���� �� �ּڰ� ���ϱ�
 * [0][0] ~ [0][2]���� �� ����
 * 1���� n���� for��
 * [n][k]���� �ּڰ��� [n-1][k�� ������ ��] �� �ּڰ�
 * ������ �࿡�� �ּڰ��� ����
 * 
 * �ð����⵵
 * n * 4
 * 
 * �ڷᱸ��
 * �Է°��� ������ int[][]
 * dp���� ������ int[][]
 * ������ ������ int
 */

public class Ex1149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		int[][] dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] = Math.min(arr[i][j] + dp[i-1][1],
							arr[i][j] + dp[i-1][2]);
				} else if (j == 1) {
					dp[i][j] = Math.min(arr[i][j] + dp[i-1][0],
							arr[i][j] + dp[i-1][2]);
				} else {
					dp[i][j] = Math.min(arr[i][j] + dp[i-1][0],
							arr[i][j] + dp[i-1][1]);
				}
			}
		}
		
		int answer= Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(dp[n-1][i], answer);
		}
		System.out.println(answer);
	}

}
