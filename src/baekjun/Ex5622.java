package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : String �迭�� ���ڿ� �ش��ϴ� ���ĺ� ���� ��,
 * �� ���ĺ��� �ش��ϴ� ���� �ε����� ã�� �ش� �ε����� �ɸ��� �ð��� �� ���ϱ�
 * 
 * �ð����⵵ : 10 * 10
 * 
 * �ڷᱸ�� : String[]
 */

public class Ex5622 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splitStr = br.readLine().split("");
		
		String[] dial = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO" ,"PQRS",
				"TUV", "WXYZ"};
		
		int sum = 0;
		for (int i = 0; i < splitStr.length; i++) {
			for (int j = 0; j< dial.length; j++) {
				if(dial[j].contains(splitStr[i])) {
					sum += j+1;
				}
			}
		}
		System.out.println(sum);
	}

}
