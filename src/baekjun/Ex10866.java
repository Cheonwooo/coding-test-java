package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex10866 {
	private static Deque<Integer> dq = new ArrayDeque<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			
			if (command.length == 1) {
				commandOptionOne(command[0]);
				continue;
			}
			commandOptionTwo(command[0], Integer.parseInt(command[1]));
		}
	}
	
	private static void commandOptionOne(String option) {
		if (option.equals("pop_front")) {
			if (dq.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(dq.pollFirst());
			}
		} else if (option.equals("pop_back")) {
			if (dq.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(dq.pollLast());
			}
		} else if (option.equals("size")) {
			System.out.println(dq.size());
		} else if (option.equals("empty")) {
			if (dq.size() == 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else if (option.equals("front")) {
			if (dq.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(dq.peekFirst());
			}
		} else if (option.equals("back")) {
			if (dq.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(dq.peekLast());
			}
		}
	}
	
	private static void commandOptionTwo(String option, int number) {
		if (option.equals("push_front")) {
			dq.offerFirst(number);
		} else if(option.equals("push_back")) {
			dq.offerLast(number);
		}
	}

}
