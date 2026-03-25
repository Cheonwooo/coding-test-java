package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex13417 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			Deque<Character> dq = new ArrayDeque<>();
			for (int i = 0; i < arr.length; i++) {
				char next = arr[i].charAt(0);
				if (dq.isEmpty()) {
					dq.add(next); 
				} else {
					if (dq.getFirst() >= next) {
						dq.addFirst(next);
					} else {
						dq.addLast(next);
					}
				}
			}
			while (!dq.isEmpty()) {
				System.out.print(dq.poll());
			}
			System.out.println();
		}
	}
}
