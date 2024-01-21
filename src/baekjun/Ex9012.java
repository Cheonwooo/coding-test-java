package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 아이디어 : Stack을 이용해서 '()'가 만들어지면 pop으로 빼내기
 * stack이 비어있고 들어오는 값이 )일 경우 바로 NO 출력
 * 들어오는 값을 넣기 전에 맨 위의 값이 (일 경우 pop하고 값 넣지 않기
 *
 * 시간복잡도 : 1
 * 
 * 자료구조 : Stack
 */

public class Ex9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] ps = br.readLine().split("");
			
			if(ps[0].equals(")")) {
				System.out.println("NO");
				continue;
			}
			
			Stack<String> stack = new Stack<>();
			stack.push(ps[0]);
			for (int j = 1; j < ps.length; j++) {
				if (stack.size() != 0 && ps[j].equals(")") && stack.peek().equals("(")) {
					stack.pop();
				} else {
					stack.push(ps[j]);
				}
			}
			
			if (stack.size() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
