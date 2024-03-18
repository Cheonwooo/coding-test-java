package programmers;

import java.util.HashSet;
import java.util.Set;

/*
 * ���̵��
 * numbers�� ������ ���� �� �ִ� ���� �����
 * ���ڸ� ������ �Ҽ����� Ȯ���ϴ� �Լ�
 * 
 * 9999999 -> 10000000���� �Ҽ��� ���� ��� boolean���� üũ�ϱ�
 * numbers�� ������ �������� ��� ����� �� ���ϱ�
 * 7C1 + ... + 7C7
 * 
 */

public class Ex42839 {
	private static int length;
	private static String[] arr, number;
	private static boolean[] visited, check;
	private static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		String numbers = "123";
		solution(numbers);
	}

	public static void solution(String numbers) {
		number = numbers.split("");
		length = numbers.length();
		
		for (int i = 0; i < length; i++) {
			visited = new boolean[numbers.length()];
			arr = new String[i+1];
			comb(i+1, 0);
		}
		
		check = new boolean[10000001];
		make_prime();
		
		int count = 0;
		for (int val : set) {
			if (val == 0 || val == 1) {
				continue;
			}
			if (!check[val]) count++;
		}
		System.out.println(count);
	}
	
	public static void comb(int n, int depth) {
		if (depth == n) {
			String pick = "";
			for (String val : arr) {
				pick += val;
			}
			
			int checkNumber= Integer.parseInt(pick);
			set.add(checkNumber);
			return;
		}
		
		for (int i = 0; i < length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = number[i];
				comb(n, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void make_prime() {
		check[0] = check[1] = true;
		
		for (int i = 2; i <= Math.sqrt(10000001); i++) {
			if (check[i]) {
				continue;
			}
			
			for (int j = i*i; j < check.length; j = j+i) {
				check[j] = true;
			}
		}
	}	
}
