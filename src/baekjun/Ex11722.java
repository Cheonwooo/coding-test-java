package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * dp�̿�
 * ���� �� �����ϴ� �κ� ������ �Ųٷ� �ϴ� �Ͱ� ����
 * 2�� for�� ��� - n-1���� 0���� for��, i���� n-1���� for��
 * 
 * �ð����⵵
 * n * n
 * 
 * �ڷᱸ��
 * �Է°��� ���� int[]
 * dp���� �Է��� int[]
 * ������ ������ int
 */

public class Ex11722 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		int max = 1;
		dp[n] = 1;
		for (int i = n-1; i >= 1; i--) {
			dp[i] = 1;
			for (int j = i+1; j < n+1; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(max);
	}

}
