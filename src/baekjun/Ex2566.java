package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 이차원 배열에 값을 입력함과 동시에 최댓값과 행/열 저장
 * 
 * 시작복잡도 : 1
 * 
 * 자료구조 : int[]
 */

public class Ex2566 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		int max = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 9; j++) {
				int number = Integer.parseInt(st.nextToken());
				
				if (number > max) {
					max = number;
					row = i;
					col = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println((row+1) + " " + (col+1));
	}

}
