    package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Ex16463 {
	
	private static List<Integer> thirtyone = List.of(1, 3, 5, 7, 8, 10, 12);
	private static List<Integer> thirty = List.of(4, 6, 9, 11);

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int day = 0;
		int answer = 0;
		for (int i = 2019; i <= n; i++) {
			int feb = 28;
			if ((i % 400 == 0) || ((i % 100 != 0) && (i % 4 == 0))) {//윤년
				feb = 29;
			} else if ((i % 400 != 0) && (i % 100 == 0)) {
				feb = 28;
			} else { 
				feb = 28;
			}
			
			for (int j = 1; j <= 12; j++) {
				if (thirtyone.contains(j)) {
					for (int k = 1; k <= 31; k++) {
						day++;
						day %= 7;
						if (k == 13 && day == 4) answer++;
					}
				} else if (thirty.contains(j)) {
					for (int k = 1; k <= 30; k++) {
						day++;
						day %= 7;
						if (k == 13 && day == 4) answer++;
					}
				} else {//2월인 경우
					for (int k = 1; k <= feb; k++) {
						day++;
						day %= 7;
						if (k == 13 && day == 4) answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
