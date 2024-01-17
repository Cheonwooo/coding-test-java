package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * ���̵�� : �Ҽ��� ���ؼ� List�� ���� �� ����, �հ� �ּڰ� ���ϱ�
 * 
 * �ð����⵵ : 10000*10000 = 100_000_000
 * 
 * �ڷᱸ�� : List
 */

public class Ex2581 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> numbers = new ArrayList<>();
		int sum = 0;
		for (int i = m; i <= n; i++) {
			List<Integer> divisors = makeDivisors(i);
			
			if(divisors.size() == 2) {
				numbers.add(i);
				sum += i;
			}
		}
		
		if(numbers.size() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(numbers.get(0));
		}
	}
	
	private static List<Integer> makeDivisors(int number) {
		List<Integer> divisors = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			if(number % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}
}
