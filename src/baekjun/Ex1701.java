package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1701 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String wordA = br.readLine();
		
		int answer = 0;
		for (int i = 0; i < wordA.length(); i++) {
			String subStr = wordA.substring(i, wordA.length());
			answer = Math.max(answer, getMaxLength(subStr));
		}
		System.out.println(answer);
	}
	
	private static int getMaxLength(String str) {
		int j = 0;
		int max = 0;
		int[] pIdxTable = new int[str.length()];
		
		for (int i = 1; i < str.length(); i++) {
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = pIdxTable[j-1];
			}
			
			if (str.charAt(i) == str.charAt(j)) {
				pIdxTable[i] = ++j;
				max = Math.max(max, pIdxTable[i]);
			}
		}
		return max;
	}

}
