package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * dpȰ��
 * �迭�� �ں��� dp�� �����ϱ�
 * dp[i]�� �ǹ̴� i��'����' ����� �������� ���� �ִ�
 * dp[i] = dp[i+Ti]���� dp[n]������ �ִ� + i��° ���ݾ�
 *  
 * �ð����⵵
 * n * (n-1)
 * 
 * �ڷᱸ��
 * dp���� ������ int[]
 * �Է°��� ������ int[][]
 *  -int[][0] = Ti
 *  -int[][1] = Pi
 */

public class Ex14501 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+2];
		int[][] callBack = new int[n+1][2];
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			callBack[i][0] = Integer.parseInt(st.nextToken());
			callBack[i][1] = Integer.parseInt(st.nextToken());
			
			for (int j = i+callBack[i][0]; j < n+2; j++) {
				dp[j] = Math.max(dp[j], callBack[i][1] + dp[i]);
			}
		}
		
		
		int max = 0;
		for (int i = 1; i < n+2; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
