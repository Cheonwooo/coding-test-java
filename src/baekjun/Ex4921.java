package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Ex4921 {
	
	private static Map<String, String> matchingBlock = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		createMatchingBlock();
		
		int testCase = 1;
		while (true) {
			String input = br.readLine();
			if (input.equals("0")) break;
			
			sb.append((testCase++) + ". ");
			
			boolean checked = true;
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < input.length(); i++) {
				String[] next = matchingBlock.get((String.valueOf(input.charAt(i)))).split(" ");
				if (i != input.length() -1 && input.charAt(i) == '2') {
					checked = false;
					break;
				}
				
				for (int j = 0; j < next.length; j++) {
					if (stack.isEmpty()) {
						stack.add(Integer.parseInt(next[j]));
					} else {
						if (stack.peek() + Integer.parseInt(next[j]) != 0) {
							checked = false;
							break;
						} else {
							stack.pop();
						}
					}
				}	
				if (!checked) break;
			}
			if (!checked || stack.size() != 0) {
				sb.append("NOT\n");
			} else {
				sb.append("VALID\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void createMatchingBlock() {
		matchingBlock.put("1", "1");
		matchingBlock.put("2", "2");
		matchingBlock.put("3", "2 1");
		matchingBlock.put("4", "-1 -2");
		matchingBlock.put("5", "-1 3");
		matchingBlock.put("6", "4 -2");
		matchingBlock.put("7", "4 3");
		matchingBlock.put("8", "-3 -4");
	}

}
