package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : 3�� 5�� ���� ���߹ݺ������� ������Ű�鼭 ���� �۰ų� ���� ������ �ݺ�
 * ���� ���� ������ �׶��� 3�� 5�� ������ ���ϰ� �ּڰ� ��
 * 
 * �ð����⵵ : ��2000 * 1000
 * 
 * �ڷᱸ�� : x
 */

public class Ex2839 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= n/3; i++) {
			for (int j = 0; j <= n/5; j++) {
				int sum = 3*i + 5*j;
				
				if (sum == n) {
					min = Math.min(i+j, min);
				}
			}
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

}
