package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex29198 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		
		List<String> words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			Arrays.sort(input);
		
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < input.length; j++) {
				sb.append(input[j]);
			}
			words.add(sb.toString());
		}
		
		Collections.sort(words);
		
		List<Character> wordToArray = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				wordToArray.add(words.get(i).charAt(j));
			}
		}
		
		Collections.sort(wordToArray);
		for (int i = 0; i < wordToArray.size(); i++) {
			System.out.print(wordToArray.get(i));
		}
	}

}
