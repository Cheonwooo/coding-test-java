package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : �� ���ĺ��� �ش��ϴ� �ƽ�Ű�ڵ忡 �� ������ ���� ���� �ִ� ��� ?���
 * charAt() - '0'�� �ϸ� �ƽ�Ű�ڵ�� ���� ����, UpperCase(), LowerCase()Ȱ��
 * 
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : int[]
 */

public class Ex1157 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		int[] num = new int[26];
		for (int i = 0; i < str.length(); i++) {
			num[str.charAt(i) - 'A']++;
		}
		
		int index = 0;
		int max = num[index];
		boolean check = false;
		
		for (int i = 1; i < num.length; i++) {
			if(max == num[i]) {
				check = true;
				continue;
			}
			if(max < num[i]) {
				check = false;
				max = num[i];
				index = i;
				continue;
			}
		}
		
		if(check) { 
			System.out.println("?");
		} else {
			System.out.println((char)(index + 65));
		}
	}
}
