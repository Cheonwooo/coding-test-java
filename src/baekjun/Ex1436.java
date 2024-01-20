package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���̵�� : 1���� �����ϴ� ���� n�� 666�� �����ϴ��� Ȯ��
 * 666�� �����Ѵٸ� count�� �����ϰ� count�� N�� �������� �ݺ��� ����
 * 
 * �ð����⵵ : 666 * 10000
 * 
 * �ڷᱸ�� : x
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
