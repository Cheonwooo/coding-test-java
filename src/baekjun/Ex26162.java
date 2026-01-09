package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex26162 {
	
	private static boolean[] prime;
	private static List<Integer> primes;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		prime = new boolean[119];
		primes = new ArrayList<>();
		
		makePrime();
		makePrimeList();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if (checkCanMakeSum(a)) {
				System.out.println("Yes");
				continue;
			}
			System.out.println("No");
		}
	}
	
	private static void makePrime() {
		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(118); i++) {
			for (int j = i * i; j <= 118; j += i) {
				if (!prime[j]) prime[j] = true;
			}
		}
	}
	
	private static void makePrimeList() {
		for (int i = 2; i < 119; i++) {
			if (!prime[i]) {
				primes.add(i);
			}
		}
	}
	
	private static boolean checkCanMakeSum(int num) {
		for (int i = 0; i < primes.size(); i++) {
			for (int j = 0; j < primes.size(); j++) {
				if ((primes.get(i) + primes.get(j)) == num) return true;
			}
		}
		return false;
	}

}
