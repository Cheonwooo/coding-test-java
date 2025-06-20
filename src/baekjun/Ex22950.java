package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex22950 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			stack.push(input.charAt(i)-'0');
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			if (stack.isEmpty()) break;
			
			int num = stack.pop();
			if (num == 1) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
