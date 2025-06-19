package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9253 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String pattern = br.readLine();
		
		if (kmp(str1, pattern) && kmp(str2, pattern)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	private static boolean kmp(String str, String pattern) {
		int[] lps = makeLps(pattern);
		
		int index = 0;
		
		for (int i = 0; i < str.length(); i++) {
			while (index > 0 && str.charAt(i) != pattern.charAt(index)) {
				index = lps[index - 1];
			}
			
			if (str.charAt(i) == pattern.charAt(index)) {
				if (index == pattern.length() - 1) {
					return true;
				} else {
					index++;
				}
			}
		}
		return false;
	}

	private static int[] makeLps(String pattern) { 
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
