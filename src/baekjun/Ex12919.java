package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12919 {
	private static int max = 0;
	private static String S;
	private static StringBuilder T;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = new StringBuilder(br.readLine());
		
		dfs(T);
		System.out.println(max);
	}
	
	private static void dfs(StringBuilder start) {
		if (start.length() < S.length()) {
			return;
		}
		
		if (start.toString().equals(S)) {
			max = 1;
			return;
		}
		
		StringBuilder next = new StringBuilder(start);
		if (next.toString().charAt(next.length()-1) == 'A') {
			next.deleteCharAt(next.length()-1);
			dfs(next);
		}
		
		next = new StringBuilder(start);
		if (next.toString().charAt(0) == 'B') {
			next.deleteCharAt(0);
			dfs(next.reverse());
		}
	}
}
