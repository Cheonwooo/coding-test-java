package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex23252 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			//b�� Ȧ������ ��, c�� Ȧ�����̸� ��.
			//b�� ¦������ ��, c�� ¦�������� ��.

			if (b % 2 == 0) {//b�� ¦���� ��
				if (a >= c && (a-c) % 2 == 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			} else {//b�� Ȧ���� ��
				if (a > 0 && a >= c && (a-c) % 2 == 0) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

}
