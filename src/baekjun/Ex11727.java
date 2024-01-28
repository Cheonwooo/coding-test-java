package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵��
 * An = An-1 + (2 * An-2)
 * 11726�� ����
 * 
 * �ð����⵵ 
 * n
 * 
 * �ڷᱸ��
 * dp ������ int[]
 * ���� ������ int
 */

public class Ex11727 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for (int i = 3; i < 1001; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
		}
		
		int answer = dp[n];
		System.out.println(answer);
	}
}
