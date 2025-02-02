package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 메모리 14320kb, 시간 104ms

public class Ex1918 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] inputs = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputs.length; i++) {
			if (inputs[i] >= 'A' && inputs[i] <= 'Z') {
				sb.append(inputs[i]);
			} else {
				if (inputs[i] == '(') {
					stack.push(inputs[i]);
				} else if (inputs[i] == ')') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					if (!stack.isEmpty()) stack.pop();
				} else {
					while (!stack.isEmpty() && priority(stack.peek()) >= priority(inputs[i])) {
						sb.append(stack.pop());
					}
					stack.push(inputs[i]);
				}
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

	public static int priority(char operation) {
		if (operation == '(') return 0;
		else if (operation == '*' || operation == '/') return 2;
		else return 1;
	}
}
