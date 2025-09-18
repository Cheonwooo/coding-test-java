package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex18258 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			
			if (input.length == 1) {
				String command = input[0];
				if (command.equals("pop")) {
					if (dq.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(dq.poll()).append("\n");
					}
				} else if (command.equals("size")) {
					sb.append(dq.size()).append("\n");
				} else if(command.equals("empty")) {
					if (dq.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
				} else if (command.equals("front")) {
					if (dq.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(dq.peek()).append("\n");
					}
				} else if (command.equals("back")) {
					if (dq.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(dq.peekLast()).append("\n");
					}
				}
			} else {
				String command = input[0];
				int num = Integer.parseInt(input[1]);
				
				dq.add(num);
			}
		}
		System.out.println(sb);
	}

}
