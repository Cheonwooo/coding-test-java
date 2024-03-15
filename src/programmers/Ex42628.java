package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/*
 * 아이디어
 * pq 한개만 사용하기
 * 
 */

public class Ex42628 {

	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		System.out.println(Arrays.toString(solution(operations)));
	}
	
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
        	String[] operation = operations[i].split(" ");
        	
        	String option = operation[0];
        	int number = Integer.parseInt(operation[1]);

        	if (option.equals("I")) {
        		pq.offer(number);
        	}
        	
        	if (pq.size() == 0) continue;
        	
        	if (option.equals("D") && number == -1) {
        		pq.poll();
        	} else if (option.equals("D") && number == 1){
        		Deque<Integer> dq = new ArrayDeque<>();
        		int size = pq.size();
        		for (int j = 0; j < size; j++) {
        			int rotate = pq.poll();
        			dq.offer(rotate);
        		}
        		dq.pollLast();
        		
        		while (!dq.isEmpty()) {
        			int rotate = dq.poll();
        			pq.offer(rotate);
        		}
        	}
        
    		
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        while (!pq.isEmpty()) {
        	dq.offer(pq.poll());
        }
        
        if (dq.size() == 0) {
        	answer[0] = answer[1] = 0;
        } else {
        	answer[0] = dq.pollLast();
        	answer[1] = dq.pollFirst();
        }
        
        return answer;
        
    }
}
