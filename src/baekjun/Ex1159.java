package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1159 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] count = new int[27];
		for (int i = 0; i < n; i++) {
			char c = br.readLine().charAt(0);
			count[(int)(c - 'a')]++;
		}
		
		for (int i = 0; i < 26; i++) {
			if (count[i] >= 5) {
				sb.append(((char)(i + 'a')));
			}
		}
		if (sb.length() == 0) {
			System.out.println("PREDAJA");
		} else {
			System.out.println(sb);
		}
	}

}
