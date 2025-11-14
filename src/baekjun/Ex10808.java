package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10808 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] answer = new int[26];
		
		String word = br.readLine();
		for (int i = 0; i < word.length(); i++) {
			answer[word.charAt(i)-'a']++;
		}
		
		for (int val : answer) {
			System.out.print(val + " ");
		}
	}

}
