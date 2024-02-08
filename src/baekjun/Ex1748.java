package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * for문을 1부터 n까지 순환
 * int를 String로 변환
 * 
 * 시간복잡도
 * n
 * 
 * 자료구조
 * 숫자 int
 * 정답을 입력할 String
 */

public class Ex1748 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int index = 1;
		int num = 10;
		
		for (int i = 1; i < n+1; i++) {
			if (i % num == 0 ) {
				index++;
				num *= 10;
			}
			answer += index;
		}
		System.out.println(answer);
	}

}
