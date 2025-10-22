package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3778 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int[] arrA = new int[26];
			int[] arrB = new int[26];
			
			String inputA = br.readLine();
			String inputB = br.readLine();
			
			for (int j = 0; j < inputA.length(); j++) {
				arrA[inputA.charAt(j) - 'a']++;
			}
			
			for (int j = 0; j < inputB.length(); j++) {
				arrB[inputB.charAt(j) - 'a']++;
			}
			
			int answer = 0;
			for (int j = 0; j < 26; j++) {
				answer += Math.abs(arrA[j] - arrB[j]);
			}
			
			sb.append("Case #" + (i+1) + ": " + answer + "\n");
		}
		System.out.println(sb);
	}

}
