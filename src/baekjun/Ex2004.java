package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵�� : https://mslim8803.tistory.com/11
 * �̷� ������ Ǯ�̸� �ܿ�°� ��
 * 
 * �ð����⵵ : 
 * 
 * �ڷᱸ�� : x
 */

public class Ex2004 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int fiveCount = getMul(n, 5) - getMul((n-m), 5) - getMul(m, 5);
		int twoCount = getMul(n, 2) - getMul((n-m), 2) - getMul(m, 2);
		
		System.out.println(Math.min(fiveCount, twoCount));
	}
	
	private static int getMul(int number, int k) {
		int count = 0;
		
		while (number !=0 ) {
			
			count += number/k;
			number /= k;
		}
		
		return count;
	}

}
