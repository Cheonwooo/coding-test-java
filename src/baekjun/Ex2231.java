package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : 1���� n-1���� ���Ʈ ������ �ݺ��� ����
 * n�� �ڸ����� ��/������ ���ϴ� ������� ���ϱ�
 * 
 * �ð����⵵ : n * 7
 * 
 * �ڷᱸ�� : x
 */

public class Ex2231 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boolean check = false;
		for (int i = 1; i < n; i++) {
			int sum = calculateDiv(i);
			
			if (n == sum) {
				System.out.println(i);
				check = true;
				break;
			}
		}
		
		if(!check) {
			System.out.println(0);
		}
	}
	
	private static int calculateDiv(int n) {
		int sum = n;
		while (n != 0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
}
