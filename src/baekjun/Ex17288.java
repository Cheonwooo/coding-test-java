package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex17288 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		int answer = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i-1) == s.charAt(i) - 1 || sb.length() == 0) {
				sb.append(s.charAt(i));
			} else {
				if (sb.length() == 3) {
					answer++;
					sb = new StringBuilder();
					sb.append(s.charAt(i));
				} else if (sb.length() > 3) {
					sb = new StringBuilder();
					sb.append(s.charAt(i));
				}
			}
		}
		if (sb.length() == 3) {
			System.out.println(answer + 1);
		} else {
			System.out.println(answer);
		}
	}

}
