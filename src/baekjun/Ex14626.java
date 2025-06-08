package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex14626 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int sum = 0;
		int index = 0;
		for (int i = 0; i < input.length(); i++) {
			int number = input.charAt(i) -'0';
			if (input.charAt(i) == '*') {
				index = i;
			} else if (i % 2 == 0) {
				sum += number;
			} else if (i % 2 != 0) {
				sum += number * 3;
			}
		}
		
		if (index % 2 == 0 ){
			System.out.println(10 - (sum % 10));
		} else {
			for (int i = 0; i < 10; i++) {
				if ((sum + i*3) % 10 == 0) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
