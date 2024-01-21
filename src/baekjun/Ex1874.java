package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * ���̵�� : �Է����� �־��� ������ List�� ���� 
 * stack�� 1���� n���� �ϳ��� �ֱ�
 * List.get(0)�� stack.peek()�� ���ٸ� stack.pop()
 * 
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : Stack
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
