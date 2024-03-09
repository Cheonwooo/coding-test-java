package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 아이디어
 * pq에 높은 값 순서대로 저장
 * queue에 (값,true/false)로 저장, location에 해당하는 수는 true
 * pq.poll()값과 같은 값이 q.poll()과 같으면 그대로 진행
 * 다르다면 q.add(q.poll())
 * 만약 true값이 나온다면 바로 그 값을 리턴
 * 
 * 시간복잡도
 * 100*99/2
 * 
 * 자료구조
 * pq
 * q
 * pq.poll()을 저장할 int
 * q.poll()을 저장할 int
 * 
 */


public class Ex42587 {
	
	public static class Process {
		int value;
		boolean check;
		
		public Process(int value, boolean check) {
			this.value = value;
			this.check = check;
		}

		public int getValue() {
			return value;
		}
		
		public boolean isCheck() {
			return check;
		}
	
	}

	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
		int location = 2;
		
		System.out.println(solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Process> q = new LinkedList<>();
		
		int answer = -1;
		
		for (int i = 0; i < priorities.length; i++) {
			pq.add(priorities[i]);
			
			if (i == location) {
				Process process = new Process(priorities[i], true);
				q.add(process);
			} else {
				Process process = new Process(priorities[i], false);
				q.add(process);
			}
		}
		
		int size = pq.size();
		int count = 0;
		for (int i = 0; i < size; i++) {
			int pqPeek = pq.poll();
			
			while (true) {
				Process processPeek = q.poll();
				int processValue = processPeek.getValue();
				boolean processCheck = processPeek.isCheck();
				
				if (processValue == pqPeek && !processCheck) {
					count++;
					break;
				} else if (processValue == pqPeek && processCheck) {
					answer = processValue;
					count++;
					break;
				} else {
					q.add(processPeek);
				}
			}
			
			if (answer != -1) break;
		}
		
		return count;
	}
	
}
