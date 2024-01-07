package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : String 배열에 숫자에 해당하는 알파벳 넣은 후,
 * 각 알파벳이 해당하는 숫자 인덱스를 찾고 해당 인덱스가 걸리는 시간의 합 구하기
 * 
 * 시간복잡도 : 10 * 10
 * 
 * 자료구조 : String[]
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
