package programmers;

import java.util.Stack;

public class Ex12909 {

	public static void main(String[] args) {
		String s = "())()(())";
		
		System.out.println(solution(s));
	}
	
	public static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		char[] c = new char[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(i);
			
			if (stack.isEmpty()) {
				stack.push(c[i]);
			} else if (stack.peek() == '('){
				if (c[i] == '(') {
					stack.push(c[i]);
				} else { //c[i] == ')
					stack.pop();
				}
			} else if (stack.peek() == ')') {
				stack.push(c[i]);
			}
		}
		
		if (stack.isEmpty()) return true;
		else return false;
	}

}
