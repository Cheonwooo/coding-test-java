package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * ���̵�� : �־��� ���� ���� ����� List�� ��ȯ�ϴ� �Լ� �����
 * ������� ��� List�� ������������ ����
 * List���� ������ ���� �־��� ���� ������ Ȯ���ϴ� �Լ� �����
 * 
 * �ð����⵵ : t * n
 * 
 * �ڷᱸ�� : List, Set
 */

public class Ex9506 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) { 
			int n = Integer.parseInt(br.readLine());
			
			if (n == -1) break;
			
			List<Integer> divisors = findDivisor(n);
			Collections.sort(divisors);
			
			if(checkPerfectNumber(n, divisors)) {
				System.out.println(makeAnswer(n, divisors));
			} else {
				System.out.println(n + " is NOT perfect.");
			}
		}
	}
	
	private static List<Integer> findDivisor(int n) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				set.add(i);
			}
		}
		
		return new ArrayList<>(set);
	}
	
	private static boolean checkPerfectNumber(int n, List<Integer> divisors) {
		int sum = 0;
		for (int i = 0; i < divisors.size()-1; i++) {
			sum += divisors.get(i);
		}
		
		if (n == sum) {
			return true;
		}
		return false;
	}
	
	private static String makeAnswer(int n, List<Integer> divisors) {
		List<String> convert = new ArrayList<>();
		for (int i = 0; i < divisors.size()-1; i++) {
			convert.add(String.valueOf(divisors.get(i)));
		}
		
		String answer = n + " = " + String.join(" + ", convert);
		return answer;
	}
}
