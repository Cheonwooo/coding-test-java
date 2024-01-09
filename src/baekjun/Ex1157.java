package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 각 알파벳에 해당하는 아스키코드에 값 저장후 같은 값이 있는 경우 ?출력
 * charAt() - '0'을 하면 아스키코드로 저장 가능, UpperCase(), LowerCase()활용
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : int[]
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
