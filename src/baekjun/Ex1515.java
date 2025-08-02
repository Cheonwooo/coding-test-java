package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1515 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] num = br.readLine().toCharArray();
		
		int index = 0;
		int n = 1;
		while (true) {
			String number = String.valueOf(n);
			for (int i = 0; i < number.length(); i++) {
				char next = number.charAt(i);
				if (num[index] == next) {
					index++;
				}
				if (index == num.length) {
					System.out.println(n);
					return;
				}
			}
			n++;
		}
	}

}
