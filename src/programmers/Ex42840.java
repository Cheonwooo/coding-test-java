package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex42840 {

	public static void main(String[] args) {
//		int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2};
		
		List<Integer> answer = solution(answers);
		for (int val : answer) {
			System.out.print(val + " ");
		}
	}
	
	public static List<Integer> solution(int[] answers) {
		List<Integer> first = Arrays.asList(1,2,3,4,5);
		List<Integer> second = Arrays.asList(2,1,2,3,2,4,2,5);
		List<Integer> third = Arrays.asList(3,3,1,1,2,2,4,4,5,5);
		List<Integer> answer = new ArrayList<>();
		
		int[][] count = new int[3][2];
		count[0][0] = 1;
		count[1][0] = 2;
		count[2][0] = 3;
		int index = 0;
		for (int i = 0; i < answers.length; i++) {
			if (index == first.size()) {
				index = 0;
			}
			if (answers[i] == first.get(index)) {
				count[0][1]++;
			}
			index++;
		}
		
		index = 0;
		for (int i = 0; i < answers.length; i++) {
			if (index == second.size()) {
				index = 0;
			}
			if (answers[i] == second.get(index)) {
				count[1][1]++;
			}
			index++;
		}
		
		index = 0;
		for (int i = 0; i < answers.length; i++) {
			if (index == third.size()) {
				index = 0;
			}
			if (answers[i] == third.get(index)) {
				count[2][1]++;
			}
			index++;
		}
		
		Arrays.sort(count, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});
		
		answer.add(count[0][0]);
		if (count[0][1] == count[1][1]) {
			answer.add(count[1][0]);
		}
		if (count[0][1] == count[2][1]) {
			answer.add(count[2][0]);
		}
		
		return answer;
	}

}
