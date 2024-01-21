package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 아이디어 : 입력으로 주어진 수열을 List에 저장 
 * stack에 1부터 n까지 하나씩 넣기
 * List.get(0)과 stack.peek()가 같다면 stack.pop()
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : Stack
 */

public class Ex1874 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int index = 1;
		while (true) {
			
			if (list.size() == 0) break;
			
			if (index == n+1 && stack.size() != 0 && !stack.peek().equals(list.get(0))) break;
			
			if (stack.size() != 0 && stack.peek().equals(list.get(0))) {
				stack.pop();
				sb.append("-").append("\n");
				list.remove(0);
				continue;
			}
			
			stack.push(index);
			index++;
			sb.append("+").append("\n");
		}
		
		if (list.size() != 0) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}
}
