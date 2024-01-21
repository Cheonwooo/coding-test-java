package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 아이디어 : stack 사용
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : Stack
 */

public class Ex10828 {
	private static Stack<Integer> stack = new Stack<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] option = br.readLine().split(" ");
			if (option.length == 1) {
				command(option[0]);
				continue;
			}
			commandPush(Integer.parseInt(option[1]));
		}
		System.out.println(sb);
	}
	
	private static void command(String option) {
		if (option.equals("pop")) {
			if (stack.size() == 0) {
				sb.append(-1).append("\n");
			} else {
				sb.append(stack.peek()).append("\n");
				stack.pop();
			}
		} else if (option.equals("size")) {
			sb.append(stack.size()).append("\n");
		} else if (option.equals("empty")) {
			if (stack.size() == 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		} else if (option.equals("top")) {
			if (stack.size() == 0) {
				sb.append(-1).append("\n");
			} else {
				sb.append(stack.peek()).append("\n");
			}
		} 
	}

	private static void commandPush(int number) {
		stack.push(number);
	}
}
