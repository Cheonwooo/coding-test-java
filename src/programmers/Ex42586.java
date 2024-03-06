package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex42586 {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1,1,1,1,1,1};
		
		List<Integer> list = solution(progresses, speeds);
		for (int val : list) {
			System.out.print(val + " ");
		}
	}
	
	public static List<Integer> solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<> ();
		Queue<Integer> processes = new LinkedList<>();
		
		for (int i = 0; i < progresses.length; i++) {
			processes.add(progresses[i]);
		}
		
		while (!processes.isEmpty()) {
			
			for (int i = 0; i < progresses.length; i++) {
				int process = processes.poll();
				
				if (process < 0) {
					processes.add(process);
				} else {
					processes.add(process+speeds[i]);
				}
			}
			
			int size = processes.size();
			for (int i = 0; i < size; i++) {
				int v = processes.poll();
				System.out.print(v + " ");
				processes.add(v);
			}
			System.out.println();
			
			int count = 0;
			boolean check = false;
			for (int i = 0; i < size; i++) {
				int process = processes.poll();
				if (process == -100) {
					processes.add(process);
					continue;
				}
				if (!check && process >= 100) {
					processes.add(-100);
					count++;
				} else {
					processes.add(process);
					check = true;
				}
			}
			
			
			if (count != 0) {
				answer.add(count);
			}
			
			check = false;
			for (int i = 0; i < size; i++) {
				int v = processes.poll();
				
				if (v > 0) {
					check = true;
				}
				processes.add(v);
			}
			
			if (!check) break;
			
			
		}
		
		return answer;
	}
}
