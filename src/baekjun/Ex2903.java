package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : 2�� n�¸�ŭ �����ֱ�
 * 
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : x
 */

public class Ex2903 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int start = 2;
		
		int end = Integer.parseInt(br.readLine());
		for (int i = 0; i < end; i++) {
			start += Math.pow(2, i);
		}
		
		System.out.println((int)Math.pow(start, 2));
	}

}
