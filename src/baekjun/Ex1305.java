package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메모리 24084kb, 시간 184ms

public class Ex1305 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String word = br.readLine();
		
		int[] table = createTable(word);
		System.out.println(n - table[n-1]);
	}

	public static int[] createTable(String word) {
		int len = word.length();
		int[] table = new int[len];
		int idx = 0;
		
		for (int i = 1; i < len; i++) {
			while (idx > 0 && word.charAt(i) != word.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if (word.charAt(i) == word.charAt(idx)) {
				idx++;
				table[i] = idx;
			}
		}
		
		return table;
	}
}
