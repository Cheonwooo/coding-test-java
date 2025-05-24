package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex28702 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int index = 0;
		String[] arr = new String[3];
		
		for (int i = 0; i < 3; i++) {
			String str = br.readLine();
			arr[i] = str;
			for (int j = 0; j < str.length(); j++) {
				if (Character.isDigit(str.charAt(j))) {
					index = i;
				};
			}
		}
		
		int next = Integer.parseInt(arr[index]) + (3-index);
		if (next % 3 == 0 && next % 5 == 0) System.out.println("FizzBuzz");
		else if (next % 3 == 0 && next % 5 != 0) System.out.println("Fizz");
		else if (next % 3 != 0 && next % 5 == 0) System.out.println("Buzz");
		else System.out.println(next);
	}

}
