package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : str�� �Է� �ް� ���� ó�� �� �ٲ㼭 newStr(1/2)�� ���� ��,
 * int�� ��ȯ�ؼ� �� ��
 * 
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : x
 */

public class Ex2908 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		String newStr1 = String.valueOf(str[0].charAt(2)) +
				String.valueOf(str[0].charAt(1)) +
				String.valueOf(str[0].charAt(0));
		
		String newStr2 = String.valueOf(str[1].charAt(2)) +
				String.valueOf(str[1].charAt(1)) +
				String.valueOf(str[1].charAt(0));
		
		int num1 = Integer.parseInt(newStr1);
		int num2 = Integer.parseInt(newStr2);
		
		System.out.println((num1 > num2) ? num1 : num2);
	}

}
