package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 맨앞, 맨끝 공백 삭제 후, split(" ")으로 나눈 후 크기 구하기
 * 
 * 시간복잡도 : length
 * 
 * 자료구조 : String[]
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
