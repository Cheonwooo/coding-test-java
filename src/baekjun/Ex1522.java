package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1522 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		int len = 0;
		for (char c : input) {
			if (c == 'a') len++;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			int bCount = 0;
			for (int j = i; j < i + len; j++) {
				if (input[j % input.length] == 'b') {
					bCount++;
				}
			}
			min = Math.min(min, bCount);
		}
		System.out.println(min);
	}

}
