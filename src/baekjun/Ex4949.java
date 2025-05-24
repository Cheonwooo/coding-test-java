package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0 ; i < str.length(); i++) {
				if (str.charAt(i) == '.') break;
				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (stack.size() != 0 && stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(str.charAt(i));
					}
				} else if (str.charAt(i) == ']') {
					if (stack.size() != 0 && stack.peek() == '[') {
						stack.pop();
					} else {
						stack.push(str.charAt(i));
					}
				}
			}
			
			if (stack.size() == 0) sb.append("yes\n");
			else sb.append("no\n");
		}
		System.out.println(sb);
	}

}
