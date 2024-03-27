package programmers;

/*
 * 아이디어
 * https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java
 */

public class Ex42883 {
	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		
		System.out.println(solution(number, k));

	}
	
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		
		int next = 0;
		int index = 0;
		
		for (int i = 0; i < number.length() - k; i++) {
			int max = 0;
			
			for (int j = index; j <= i + k; j++) {
				int cur = number.charAt(j) - '0';
				
				if (max < cur) {
					max = cur;
					next = j;
				}
			}
			sb.append(max);
			index = next + 1;
		}
		return sb.toString();
	}	
}
