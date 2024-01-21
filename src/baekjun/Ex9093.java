package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 단어가 들어오면 역순으로 바꿔주는 함수 만들고 String을 반환하는 함수 만들기
 * 
 * 시간복잡도 : n * 1000
 * 
 * 자료구조 : String[]
 */

public class Ex9093 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] sentence = br.readLine().split(" ");
			
			for (int j = 0; j < sentence.length; j++) {
				sentence[j] = reverseSentence(sentence[j]);
			}
			
			for (int j = 0; j < sentence.length; j++) {
				System.out.print(sentence[j] + " ");
			}
		}
	}
	
	private static String reverseSentence(String sentence) {
		String[] split = sentence.split("");
		
		int left = 0;
		int right = split.length-1;
		
		while (left < right) {
			String temp = split[left];
			split[left] = split[right];
			split[right] = temp;
			left++;
			right--;
		}
		
		return String.join("", split);
	}

}
