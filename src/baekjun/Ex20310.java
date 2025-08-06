package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex20310 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s = br.readLine().toCharArray();
		int oneCount = 0;
		int zeroCount = 0;
		
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '1') oneCount++;
			else zeroCount++;
		}
		oneCount /= 2;
		zeroCount /= 2;
		
		int index = 0;
		while (true) {
			if (s[index] == '1') {
				s[index] = '.';
				oneCount--;
			}
			
			if (oneCount == 0) break;
			index++;
		}
		
		index = s.length-1;
		while (true) {
			if (s[index] == '0') {
				s[index] = '.';
				zeroCount--;
			}
			
			if (zeroCount == 0) break;
			index--;
		}
		
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '1' || s[i] == '0') {
				System.out.print(s[i]);
			}
		}
	}

}
