package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * dp �̿�
 * 1,2�� ���������� �� �߿��� �ִ� ����
 * dp[0][n] = max(dp[1][n-2], dp[0][n-2]+d[1][n-1])
 * dp[1][n] = max(dp[0][n-2], dp[0][n-1]+d[1][n-2])
 * for�� n�� 2���� 100000����
 * 
 * �ð����⵵
 * n
 * 
 * �ڷᱸ��
 * �Է°��� ������ int[][]
 * dp���� ������ int[][]
 * ������ ������ int
 */

public class Ex9465 {
	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][n+1];
			int[][] stickers = new int[2][n+1];
			
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int k = 1; k < n+1; k++) {
					stickers[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];
			for (int j = 2; j < n+1; j++) {
				
				int maxIndex0 = calculateMax(dp[1][j-2], dp[1][j-1], dp[0][j-2]);
				int maxIndex1 = calculateMax(dp[0][j-2], dp[0][j-1], dp[1][j-2]);
				
				dp[0][j] = Math.max(maxIndex0 + stickers[0][j], dp[0][j]);
				dp[1][j] = Math.max(maxIndex1 + stickers[1][j], dp[1][j]);
			}
			
			int answer = Math.max(dp[0][n], dp[1][n]);
			System.out.println(answer);
		}
	}
	
	private static int calculateMax(int number1, int number2, int number3) {
		int compareNumber = Math.max(number1, number2);
		int max = Math.max(number3, compareNumber);
		
		return max;
	}
	
}
