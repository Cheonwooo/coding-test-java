package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵�� : ������ �迭�� ���� �Է��԰� ���ÿ� �ִ񰪰� ��/�� ����
 * 
 * ���ۺ��⵵ : 1
 * 
 * �ڷᱸ�� : int[]
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
