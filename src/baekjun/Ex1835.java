package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex1835 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n];
		
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			dq.add(i);
		}
		
		int idx = 1;
		while (!dq.isEmpty()) {
			for (int i = 0; i < idx; i++) {
				dq.addLast(dq.pollFirst());
			}
			int num = dq.pollFirst();
			answer[num] = idx++;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}