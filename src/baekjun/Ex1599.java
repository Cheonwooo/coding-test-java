package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex1599 {
	
	private static class Word implements Comparable<Word> {
		String word;
		String incodedWord;

		public Word(String word, String incodedWord) {
			this.word = word;
			this.incodedWord = incodedWord;
		}
		
		public int compareTo(Word o) {
			return this.incodedWord.compareTo(o.incodedWord); 
		}
	}
	
	private static Map<String, Integer> dictionary = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		makeDic();
		int n = Integer.parseInt(br.readLine());
		Word[] words = new Word[n];
		//입력받은 값을 숫자로 변환 후 원래의 알파벳으로 변환해서 String 넣기
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			String savedWord = word;
			word = word.replaceAll("ng", String.valueOf(dictionary.get("ng") + " "));
			
			for (String key : dictionary.keySet()) {
				word = word.replaceAll(key, String.valueOf(dictionary.get(key)) + " ");
			}
				
			String[] splitWord = word.split(" ");
			String incoded = "";
			for (int j = 0; j < splitWord.length; j++) {
				int seq = Integer.parseInt(splitWord[j]);
				
				incoded += String.valueOf((char)(seq + 'a'));
			}
			words[i] = new Word(savedWord, incoded);
		}
		
		Arrays.sort(words);
		for (Word word : words) {
			System.out.println(word.word);
		}
	}
	
	private static void makeDic() {
		dictionary.put("a", 1);
		dictionary.put("b", 2);
		dictionary.put("k", 3);
		dictionary.put("d", 4);
		dictionary.put("e", 5);
		dictionary.put("g", 6);
		dictionary.put("h", 7);
		dictionary.put("i", 8);
		dictionary.put("l", 9);
		dictionary.put("m", 10);
		dictionary.put("n", 11);
		dictionary.put("ng", 12);
		dictionary.put("o", 13);
		dictionary.put("p", 14);
		dictionary.put("r", 15);
		dictionary.put("s", 16);
		dictionary.put("t", 17);
		dictionary.put("u", 18);
		dictionary.put("w", 19);
		dictionary.put("y", 20);
	}
}
