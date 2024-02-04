package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * E S M �� 1�� ���� ��Ű�鼭 �Է� ���� ���� ������ �� ���
 * 
 * �ð����⵵
 * 
 *  
 * �ڷᱸ��
 * �Է°��� ������ int[]
 * ������ ������ int
 */

public class Ex1476 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] time = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		time[0] = Integer.parseInt(st.nextToken());
		time[1] = Integer.parseInt(st.nextToken());
		time[2] = Integer.parseInt(st.nextToken());

		int answer = 0;
		
		int e = 1;
		int s = 1;
		int m = 1;
		while(true) {
			answer++;
			
			if (time[0] == e && time[1] == s && time[2] == m) break;
			
			e++;
			s++;
			m++;
			
			if (e == 16) e = 1;
			if (s == 29) s = 1;
			if (m == 20) m = 1;
		}
		System.out.println(answer);
	}

}
