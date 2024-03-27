package programmers;

import java.util.Stack;

public class Ex42883_2 {

	public static void main(String[] args) {

		String number = "4177252841";
		int k = 4;
		
		System.out.println(solution(number, k));
	}
	
	public static String solution(String number, int k) {
		char[] answer = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = stack.get(i);
		}
		
		return new String(answer);
	}

}
