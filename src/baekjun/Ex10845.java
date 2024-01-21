package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex10845 {
	private static Deque<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] option = br.readLine().split(" ");
			
			if (option.length == 1) {
				command(option[0]);
			} else {
				q.addLast(Integer.parseInt(option[1]));
			}
		}
	}
	
	private static void command(String option) {
		if (option.equals("pop")) {
			if (q.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(q.pollFirst());
			}
		} else if (option.equals("size")) {
			System.out.println(q.size());
		} else if (option.equals("empty")) {
			if (q.size() == 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		} else if (option.equals("front")) {
			if (q.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(q.peekFirst());
			}
		} else if (option.equals("back")) {
			if (q.size() == 0) {
				System.out.println(-1);
			} else {
				System.out.println(q.peekLast());
			}
		}
	}

}
