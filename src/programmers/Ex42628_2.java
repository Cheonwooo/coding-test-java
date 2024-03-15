package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Ex42628_2 {

	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		System.out.println(Arrays.toString(solution(operations)));
	}
	
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < operations.length; i++) {
			String[] operation = operations[i].split(" ");
			
			String option = operation[0];
			int number = Integer.parseInt(operation[1]);
			
			if (option.equals("I")) {
				pq.offer(number);
				reverse.offer(number);
			} else if (option.equals("D")) {
				if (pq.size() == 0 && reverse.size() == 0) continue;
				
				if (number > 0) {
					int pollNumber = reverse.poll();
					pq.remove(pollNumber);
				} else {
					int pollNumber = pq.poll();
					reverse.remove(pollNumber);
				}
			}
		}
		if (pq.size() == 0 || reverse.size() == 0) {
			answer[0] = answer[1] = 0;
		} else {
			answer[0] = reverse.poll();
			answer[1] = pq.poll();
		}
		
		return answer;
	}

}
