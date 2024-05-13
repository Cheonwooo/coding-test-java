package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1213 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int T = Integer.parseInt(br.readLine());
			String searchWord = br.readLine();
			String sentence = br.readLine();
			
			sentence = sentence.replaceAll(searchWord, " 1");
			String[] sentences = sentence.split(" ");
			
			sb.append(sentences.length-1).append("\n");
		}
		System.out.println(sb);
	}

}
