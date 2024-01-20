package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 1부터 증가하는 숫자 n이 666을 포함하는지 확인
 * 666을 포함한다면 count를 증가하고 count가 N과 같아지면 반복문 종료
 * 
 * 시간복잡도 : 666 * 10000
 * 
 * 자료구조 : x
 */

public class Ex1436 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		int number = 0;
		while (true) { 
			number++;
			
			if (checkNumber(number)) {
				count++;
			}
			
			if (count == n) {
				System.out.println(number);
				break;
			}
		}
	}

	private static boolean checkNumber(int number) {
		int countSix = 0;
		
		while (number != 0) {
			if (countSix == 3) break;
			
			int div = number%10;
			if(div == 6) {
				countSix++;
				number /= 10;
				continue;
			}
			number /= 10;
			countSix = 0;
		}
		
		if (countSix >= 3) {
			return true;
		}
		return false;
	}
}
