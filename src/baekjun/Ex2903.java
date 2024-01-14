package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 2의 n승만큼 더해주기
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : x
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
