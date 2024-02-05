package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * dp�̿�
 * n��° �ִ��� n-1���� 1���� n��° ������ ���� �� �� �ִ񰪰� ���ϱ�
 * dp[n] = dp[n-1-n] + arr[n]
 * 
 * �ð����⵵
 * n * n = n^2
 * 
 * �ڷᱸ��
 * �Է°��� ������ int[]
 * dp���� ������ int[]
 */

public class Ex11055 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		for (int i = 2; i < n+1; i++) {
			dp[i] = arr[i];
			for (int j = i-1; j >= 1; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i < n+1; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
