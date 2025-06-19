package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex16916 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String pattern = br.readLine();
		
		int answer = kmp(str, pattern);
		System.out.println(answer);
	}
	
	private static int kmp(String str, String pattern) {
		int[] lps = lps(pattern);
		
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			while (index > 0 && str.charAt(i) != pattern.charAt(index)) {
				index = lps[index - 1];
			}
			
			if (str.charAt(i) == pattern.charAt(index)) {
				if (index == pattern.length() - 1) {
					return 1;
				} else {
					index++;
				}
			}
		}
		return 0;
	}
	
	private static int[] lps(String pattern) {
		int n = pattern.length();
		int[] lps = new int[n];
		
		int index = 0;
		
		for (int i = 1; i < n; i++) {
			while (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
				index = lps[index - 1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(index)) {
				index++;
				lps[i] = index;
			}
		}
		return lps;
	}

}
