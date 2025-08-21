package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex30089 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				StringBuilder sb = new StringBuilder(word.substring(0, j));
				String reverseWord = sb.reverse().toString();
				
				String newWord = word + reverseWord;
				
				boolean reverse = true;
				int index = newWord.length()-1;
				for (int k = 0; k < word.length(); k++) {
					if (newWord.charAt(index--) != word.charAt(k)) {
						reverse = false;
						break;
					}
				}
				
				if (reverse) {
					System.out.println(newWord);
					break;
				}
			}
		}
	}

}
