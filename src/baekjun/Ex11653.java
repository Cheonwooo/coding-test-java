package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 주어진 값이 1이 될 때 까지 2부터 n까지 나눈다.
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : x
 */

public class Ex11653 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		
		if (number  == 1) {
			System.out.println();
		} else {
			StringBuilder sb = new StringBuilder();
			
			int index = 2;
			while (number != 1) {
				if (number % index == 0) {
					number /= index;
					sb.append(index).append("\n");
				} else {
					index++;
				}
			}
			
			System.out.println(sb);
		}
	}
}
