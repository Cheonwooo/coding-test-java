package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13172 {
	
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		
		long answer = 0;
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			
			long euclid = gcd(n, k);
			
			n /= euclid;
			k /= euclid;
			
			answer += k * findValue(n, MOD - 2) % MOD;
			answer %= MOD;
		}
		System.out.println(answer);
	}
	
	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	private static long findValue(long n, long mod) {
		if (mod == 1) return n;
		
		long temp = findValue(n, mod / 2);
		
		if (mod % 2 == 1) {
			return temp * temp % MOD * n % MOD;
		} else {
			return temp * temp % MOD;
		}
	}
}
