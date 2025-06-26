package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex30822 {

	private static char[] arr = {'u', 'o', 's', 'p', 'c'};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] ch = new int[26];
		
		String word = br.readLine();
		for (int i = 0; i < word.length(); i++) {
			ch[word.charAt(i)-'a']++;
		}

		int answer = 0;
		while (true) {
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (ch[arr[i]-'a'] >= 0) ch[arr[i]-'a']--;
				if (ch[arr[i]-'a'] == -1) break;
				count++;
			}
			if (count != 5) break;
			else answer++;
		}
		
		System.out.println(answer);
	}
}
