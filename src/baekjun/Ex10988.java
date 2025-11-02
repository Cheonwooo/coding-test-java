package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10988 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder str1 = new StringBuilder(br.readLine());
		String wordA = String.valueOf(str1);
		StringBuilder str2 = str1.reverse();
		String wordB = String.valueOf(str2);
		
		if (wordA.equals(wordB)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
