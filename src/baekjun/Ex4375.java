package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4375 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while ((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			
			int count = 1;
			int number = 1;
			
			while ((number %= n) != 0) {
				count++;
				number = number*10 + 1;
			}
			System.out.println(count);
		}
	}
}
