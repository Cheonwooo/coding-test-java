package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// �޸� 27448kb, �ð� 188ms

public class Ex1644 {
	
	private static final int SIZE = 4_000_001;
	private static boolean[] prime;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		//�Ҽ� ���ϴ� �Լ� SIZE * sqrt(SIZE) = 80���̶� �ð� �ʰ�
		//�����佺�׳׽��� ü�� ���ϱ� O(Nlog(logN))
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

	//�����佺�׳׽��� ü
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
