package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 아이디어 : 스택 이용
 * (가 나오면 push
 * )가 나오면 pop
 * )가 나오고 그 전이(라면 stack사이즈만큼 더하기
 * )가 나오고 그 전이 )라면 1만 더하기
 * 
 * 시간복잡도 : s
 * 
 * 자료구조 : stack
 * 
 */

public class Ex10799 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		int answer = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push('(');
				continue;
			}
			if (str.charAt(i) == ')') {
				stack.pop();
				
				if (str.charAt(i-1) == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
