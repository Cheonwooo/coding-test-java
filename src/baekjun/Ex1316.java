package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 맨 첫 알파벳 true로 시작, 앞뒤 같으면 continue, 다르면 true인지 
 * 아닌지에 따라 그룹 단어인지 체크 
 * 
 * 
 * 시간복잡도 : 100 * 100
 * 
 * 자료구조 : boolean[]
 */

public class Ex1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			boolean[] groupWord = new boolean[26];
			boolean check = false;
			
			groupWord[str.charAt(0) - 'a'] = true;
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j-1) == str.charAt(j)) continue;
				
				int index = str.charAt(j) - 'a';
				if (!groupWord[index]) {
					groupWord[index] = true;
					continue;
				}
				if (groupWord[index]) {
					check = true;
					break;
				}
			}
			if(check) continue;
			count++;
		}
		System.out.println(count);
	}

}
