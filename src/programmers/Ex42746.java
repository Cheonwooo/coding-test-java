package programmers;

import java.util.Arrays;
import java.util.Comparator;

/*
 * ���̵��
 * ���� �ڸ��� ū ���� ����
 * ���� �ڸ��� ���ٸ� ���� �ڸ�
 * ���� �ڸ��� ���ٸ� �����ڸ�
 */

public class Ex42746 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,30,34,5,9,912,978};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String[] newNumbers = Arrays.stream(numbers)
				.mapToObj(String::valueOf)
				.toArray(String[]::new);
		
		Arrays.sort(newNumbers, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		if (newNumbers[0].equals("0")) {
			return "0";
		} else {
			String answer = String.join("", newNumbers);
			return answer;
		}
	}
}
