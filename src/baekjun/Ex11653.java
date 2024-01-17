package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : �־��� ���� 1�� �� �� ���� 2���� n���� ������.
 * 
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : x
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
