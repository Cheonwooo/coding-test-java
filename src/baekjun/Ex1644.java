package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 메모리 27448kb, 시간 188ms

public class Ex1644 {
	
	private static final int SIZE = 4_000_001;
	private static boolean[] prime;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		//소수 구하는 함수 SIZE * sqrt(SIZE) = 80억이라 시간 초과
		//에라토스테네스의 체로 구하기 O(Nlog(logN))
		findPrime();
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			if (!prime[i]) list.add(i);
		}
		list.add(0);
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		while (left <= right && right < list.size()) {
			if (sum < n) {
				sum += list.get(right++);
			} else {
				if (sum == n) {
					cnt++;
				}
				sum -= list.get(left++);
			}
		}
		System.out.println(cnt);
	}

	//에라토스테네스의 체
	public static void findPrime() {
		prime = new boolean[SIZE];
		
		prime[0] = prime[1] = true;
		
		for (int j = 2; j < Math.sqrt(SIZE); j++) {
			if (prime[j]) continue;
			
			for (int k = j*j; k < prime.length; k = k+j) {
				prime[k] = true;
			}
		}
	}
}
