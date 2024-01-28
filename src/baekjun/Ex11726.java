package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵��
 * ��ȭ�� : An = An-1 + An-2
 * ��ȭ���� ���ϱ� ���� for�� ���鼭 dp�� ����
 * n���� dp�� ���� �� 10007�� ������
 * 
 * �ð����⵵ : n(for�� 1�� ��)
 * 
 * �ڷᱸ��
 * dp�� ������ int[]
 * ������ ������ int
 */

public class Ex11726 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
			
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
			
		int answer = dp[n] % 10007;
		System.out.println(answer);
	}
}
