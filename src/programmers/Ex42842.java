package programmers;

/*
 * 아이디어
 * yellow를 소인수분해 하기
 * for문 1부터 Math.sqrt(yellow)까지
 * yellow % i == 0 이라면 ((yellow/i)(큰수)+2)*2 +(i(작은수)*2) == brown이라면 정답
 * 
 * 시간복잡도 
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
