package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex1218 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			
			if (str.length%2 != 0) {
				sb.append(0).append("\n");
				continue;
			}
			
			Stack<String> stack = new Stack<>();
			stack.push(str[0]);
			
			for (int i = 1; i < str.length; i++) {
				if (stack.size() == 0) {
					stack.push(str[i]);
					continue;
				}
				
				if (str[i].equals("}") && stack.peek().equals("{")) {
					stack.pop();
				} else if (str[i].equals("]") && stack.peek().equals("[")) {
					stack.pop();
				} else if (str[i].equals(")") && stack.peek().equals("(")) {
					stack.pop();
				} else if (str[i].equals(">") && stack.peek().equals("<")) {
					stack.pop();
				} else {
					stack.push(str[i]);
				}
			}
			
			if (stack.size() == 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}
