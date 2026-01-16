package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex28279 {
	
	private static Deque<Integer> dq = new ArrayDeque<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] query = br.readLine().split(" ");
			
			result(query);
		}
		System.out.println(sb);
	}

	private static void result(String[] query) {
		int command = Integer.parseInt(query[0]);
		if (command == 1) {
			dq.addFirst(Integer.parseInt(query[1]));
		} else if (command == 2) {
			dq.addLast(Integer.parseInt(query[1]));
		} else if (command == 3) {
			if (dq.size() == 0) {
				sb.append(-1 + "\n");
			} else {
				sb.append(dq.pollFirst() + "\n");
			}
		} else if (command == 4) {
			if (dq.size() == 0) {
				sb.append(-1 + "\n");
			} else {
				sb.append(dq.pollLast() + "\n");
			}
		} else if (command == 5) {
			sb.append(dq.size() + "\n");
		} else if (command == 6) {
			if (dq.size() == 0) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		} else if (command == 7) {
			if (dq.size() == 0) {
				sb.append(-1 + "\n");
			} else {
				sb.append(dq.peekFirst() + "\n");
			}
		} else {
			if (dq.size() == 0) {
				sb.append(-1 + "\n");
			} else {
				sb.append(dq.peekLast() + "\n");
			}
		}
	}
}
