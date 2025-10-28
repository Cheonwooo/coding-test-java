package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1622 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String A = br.readLine();
			if (A == null) break;
			String B = br.readLine();
			
			int[] a = new int[26];
			int[] b = new int[26];
			
			for (int i = 0; i < A.length(); i++) {
				a[A.charAt(i) - 'a']++;
			}
			
			for (int i = 0; i < B.length(); i++) {
				b[B.charAt(i) - 'a']++;
			}
			
			for (int i = 0; i < 26; i++) {
				if (a[i] != 0 && b[i] != 0) {
					int count = Math.min(a[i], b[i]);
					for (int j = 0; j < count; j++) {
						sb.append((char)(i + 'a'));
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
