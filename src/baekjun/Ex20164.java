package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex20164 {
	
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if ((input.charAt(i) - '0') % 2 != 0) count += 1;
		}
		calculateOdd(input, count);
		
		System.out.println(min + " " + max);
	}
	
	private static void calculateOdd(String number, int count) {
		if (number.length() == 1) {
			min = Math.min(min, count);
			max = Math.max(max, count);
			return;
		}
		
		String[] numbers = number.split("");
		if (numbers.length == 2) {
			int plus = 0;
			int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
			
			if ((sum / 10) % 2 != 0) plus += 1;
			if (sum % 2 != 0) plus += 1;
			
			calculateOdd(String.valueOf(sum), count + plus);
		} else {
			for (int i = 0; i < numbers.length - 2; i++) {
				for (int j = i+1; j < numbers.length - 1; j++) {
					int plus = 0;
					int sum = Integer.parseInt(number.substring(0, i+1))
							+ Integer.parseInt(number.substring(i+1, j+1))
							+ Integer.parseInt(number.substring(j+1));
					String num = String.valueOf(sum);
					for (int l = 0; l < num.length(); l++) {
						if ((num.charAt(l) - '0') % 2 != 0) {
							plus += 1;
						}
					}
					calculateOdd(num, count + plus);
				}
			}
		}
	}

}
