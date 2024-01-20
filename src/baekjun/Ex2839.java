package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어 : 3과 5의 값을 이중반복문으로 증가시키면서 값이 작거나 같을 때까지 반복
 * 같은 값이 나오면 그때의 3과 5의 개수를 구하고 최솟값 비교
 * 
 * 시간복잡도 : 약2000 * 1000
 * 
 * 자료구조 : x
 */

public class Ex2839 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= n/3; i++) {
			for (int j = 0; j <= n/5; j++) {
				int sum = 3*i + 5*j;
				
				if (sum == n) {
					min = Math.min(i+j, min);
				}
			}
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

}
