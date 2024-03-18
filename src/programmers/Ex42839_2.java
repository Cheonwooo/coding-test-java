package programmers;

import java.util.HashSet;
import java.util.Set;

public class Ex42839_2 {
	private static int length;
	private static String[] arr, number;
	private static boolean[] visited, check = new boolean[10000001];
	private static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
		int count = 0;
		number = numbers.split("");
		length = numbers.length();
		
		for (int i = 0; i < numbers.length(); i++) {
			arr = new String[i+1];
			visited = new boolean[numbers.length()];
			comb(i+1, 0);
		}
		
		make_prime();
		
		for (int val : set) {
			if(!check[val]) count++;
		}
		return count;
	}
	
	public static void comb(int n, int depth) {
		if (depth == n) {
			String pick = "";
			for (String val : arr) {
				pick += val;
			}
			
			int pickNumber = Integer.parseInt(pick);
			set.add(pickNumber);
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
		
		for (int i = 2; i < Math.sqrt(10000001); i++) {
			if (check[i]) {
				continue;
			}
			
			for (int j = i*i; j < check.length; j += i) {
				check[j] = true;
			}
		}
	}
}
