package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1543 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sentence = br.readLine();
		String findWord = br.readLine();
		
		int answer = 0;
		for (int i = 0 ; i < sentence.length() - findWord.length() + 1; i++) {
			String subSentence = sentence.substring(i, i + findWord.length());
			if (subSentence.equals(findWord)) {
				answer++;
				i += findWord.length() - 1;
			}
		}
		System.out.println(answer);
	}

}
