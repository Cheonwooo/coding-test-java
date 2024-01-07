package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : �Ǿ�, �ǳ� ���� ���� ��, split(" ")���� ���� �� ũ�� ���ϱ�
 * 
 * �ð����⵵ : length
 * 
 * �ڷᱸ�� : String[]
 */

public class Ex1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		if(str.equals(" ")) {
			System.out.println(0);
		} else {
			String[] splitStr = str.trim().split(" ");
			
			System.out.println(splitStr.length);
		}
	}
}
