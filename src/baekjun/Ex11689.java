package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11689 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long count = n;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				count = count - (count / i);
				while (n % i == 0) {
					n /= i;
				}
			}
		}
		if (n > 1) {
			count = count - (count / n);
		}
		System.out.println(count);
	}
}
