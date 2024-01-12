package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * ���̵�� : List<String>���� ���� ����� ���ÿ� �ִ� ���� ����,
 * �ε��� 0���� �ִ� ���̱��� ��ȯ�ϸ鼭 ���� ����ϱ�
 * 
 * �ð����⵵ : 5 * 15
 * 
 * �ڷᱸ�� : List, StringBuilder
 */

public class Ex10798 {
	private static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> words = new ArrayList<>();
		
		int maxLength = 0;
		for (int i = 0; i < 5; i++) {
			String word = br.readLine();
			words.add(word);
			
			if(maxLength < word.length()) {
				maxLength = word.length();
			}
		}
		
		String answer = "";
		for (int i = 0; i < maxLength; i++) {
			answer = continuousWords(words, i);
		}
		
		System.out.println(answer);
	}
	
	private static String continuousWords(List<String> words, int index) {
		for (int j = 0; j < 5; j++) {
			
			String word = words.get(j);
			
			if(word.length() < index+1) {
				 continue;
			}
			result.append(word.charAt(index));
		}
		return result.toString();
	}
}
