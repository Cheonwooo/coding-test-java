package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ex12906 {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		
		solution(arr);
	}

	public static Deque<Integer> solution(int[] arr) {
		Deque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (dq.isEmpty()) {
				dq.addLast(arr[i]);
				continue;
			}
			
			if (dq.peekLast() == arr[i]) {
				continue;
			} else {
				dq.addLast(arr[i]);
			}
		}
		
		return dq;
	}
}
