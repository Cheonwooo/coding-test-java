package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : 
 * 1~1,000,000���� �Ҽ� ���� ���ϱ�
 * �Ҽ��� �� ���� ���� ������ üũ, ¦������ ���� ���� ���� �� ���� �Ҽ��� ���ԵǾ� ������ ��
 * ���ٸ� �Ҽ��� ��� ��ȯ
 * 
 * �ð����⵵ : 100,000
 * 
 * �ڷᱸ�� : boolean[]
 */

public class Ex6588 {
	private static boolean[] check = new boolean[1000001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		checkDiv();
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			int number = Integer.parseInt(br.readLine());
			
			if (number == 0) { 
				break;
			}
			
			boolean isMakeFunction = false;
			for (int i = 0; i < 1000001; i++) {
				if (!check[i] && !check[number-i]) {
					sb.append(number).append(" = ").append(i)
					.append(" + ").append(number-i).append("\n");
					
					isMakeFunction = true;
					break;
				}
			}
			
			if (!isMakeFunction) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void checkDiv() {
		check[0] = true;
		check[1] = true;
		
		for (int i = 2; i*i <= 1000000; i++) {
			
			for (int j = i*i; j <= 1000000; j += i) {
				check[j] = true;
			}
		}
	}
}
