package programmers;

/*
 * ���̵��
 * yellow�� ���μ����� �ϱ�
 * for�� 1���� Math.sqrt(yellow)����
 * yellow % i == 0 �̶�� ((yellow/i)(ū��)+2)*2 +(i(������)*2) == brown�̶�� ����
 * 
 * �ð����⵵ 
 * Math.sqrt(2_000_000)
 * 
 */

public class Ex42842 {

	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		int[] arr = solution(brown, yellow);
		
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		for (int i = 1; i <= Math.sqrt(yellow); i++) {
			if (yellow % i == 0) {
				int moq = yellow/i;
				
				int sum = ((moq+2)*2) + (i*2);
				
				if (brown == sum) {
					answer[0] = moq+2;
					answer[1] = i+2;
				}
			}
		}
		return answer;
	}

}
