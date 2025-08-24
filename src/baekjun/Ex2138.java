package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex2138 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] origin = br.readLine().toCharArray();
		char[] end = br.readLine().toCharArray();
		
		char[] firstButton = Arrays.copyOf(origin, origin.length);
		firstButton[0] = origin[0] == '0' ? '1' : '0';
		firstButton[1] = origin[1] == '0' ? '1' : '0';
		
		int originCount = 0;
		int firstCount = 1;
		
		for (int i = 1; i < origin.length; i++) {
			if (origin[i-1] != end[i-1]) {
				origin[i-1] = origin[i-1] == '0' ? '1' : '0';
				origin[i] = origin[i] == '0' ? '1' : '0';
				
				if (i != origin.length - 1) {
					origin[i+1] = origin[i+1] == '0' ? '1' : '0';
				}
				
				originCount++;
			}
			
			if (firstButton[i-1] != end[i-1]) {
				firstButton[i-1] = firstButton[i-1] == '0' ? '1' : '0';
				firstButton[i] = firstButton[i] == '0' ? '1' : '0';
				
				if (i != firstButton.length - 1) {
					firstButton[i+1] = firstButton[i+1] == '0' ? '1' : '0';
				}
				
				firstCount++;
			}
		}
		
		if (checkButton(origin, end)) {
			System.out.println(originCount);
		} else if (checkButton(firstButton, end)) {
			System.out.println(firstCount);
		} else {
			System.out.println(-1);
		}
	}
	
	private static boolean checkButton(char[] origin, char[] end) {
		for (int i = 0; i < origin.length; i++) {
			if (origin[i] != end[i]) return false;
		}
		return true;
	}

}
