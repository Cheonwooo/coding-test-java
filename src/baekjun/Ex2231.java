package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 1부터 n-1까지 브루트 포스로 반복문 돌기
 * n의 자릿수는 몫/나머지 구하는 방법으로 구하기
 * 
 * 시간복잡도 : n * 7
 * 
 * 자료구조 : x
 */

public class Ex2231 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boolean check = false;
		for (int i = 1; i < n; i++) {
			int sum = calculateDiv(i);
			
			if (n == sum) {
				System.out.println(i);
				check = true;
				break;
			}
		}
		
		if(!check) {
			System.out.println(0);
		}
	}
	
	private static int calculateDiv(int n) {
		int sum = n;
		while (n != 0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
}
