package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵��
 * for���� 1���� n���� ��ȯ
 * int�� String�� ��ȯ
 * 
 * �ð����⵵
 * n
 * 
 * �ڷᱸ��
 * ���� int
 * ������ �Է��� String
 */

public class Ex1748 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int index = 1;
		int num = 10;
		
		for (int i = 1; i < n+1; i++) {
			if (i % num == 0 ) {
				index++;
				num *= 10;
			}
			answer += index;
		}
		System.out.println(answer);
	}

}
