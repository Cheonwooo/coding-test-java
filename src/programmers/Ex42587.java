package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * ���̵��
 * pq�� ���� �� ������� ����
 * queue�� (��,true/false)�� ����, location�� �ش��ϴ� ���� true
 * pq.poll()���� ���� ���� q.poll()�� ������ �״�� ����
 * �ٸ��ٸ� q.add(q.poll())
 * ���� true���� ���´ٸ� �ٷ� �� ���� ����
 * 
 * �ð����⵵
 * 100*99/2
 * 
 * �ڷᱸ��
 * pq
 * q
 * pq.poll()�� ������ int
 * q.poll()�� ������ int
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
