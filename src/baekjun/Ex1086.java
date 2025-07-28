package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1086 {
	
	private static int n, divNum, max;
	private static int[][] mod;
	private static long[][] dp;
	private static long p, q = 1;
	private static String[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new String[n];
		factorial();
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		divNum = Integer.parseInt(br.readLine());
		
		max = (1 << n) - 1;
		dp = new long[1 << n][divNum];
		mod = new int[n][divNum];
		
		for (int i = 0; i < divNum; i++) {
			for (int j = 0; j < n; j++) {
				mod[j][i] = -1;
			}
			for (int j = 0; j <= max; j++) {
				dp[j][i] = -1;
			}
		}
		
		p = dynamic(0, 0);
		if (p == 0) {
			System.out.println("0/1");
		} else {
			long num = gcd(p, q);
			p /= num;
			q /= num;
			
			System.out.println(p + "/" + q);
		}
	}
	
	private static long dynamic(int bit, int module) {
		if (dp[bit][module] != -1) return dp[bit][module];
		if (bit == max) return module == 0 ? 1 : 0;
		
		long count = 0;
		for (int i = 0; i < n; i++) {
			int idx = 1 << i;
			if ((bit&idx) == 0) {
				count += dynamic(bit|idx, getMod(i, module));
			}
		}
		return dp[bit][module] = count;
	}
	
	private static int getMod(int idx, int module) {
		if (mod[idx][module] != -1) return mod[idx][module];
		int cur = module;
		int len = arr[idx].length();
		for (int i = 0; i < len; i++) {
			cur *= 10;
			cur += (arr[idx].charAt(i) - '0');
			cur %= divNum;
		}
		return mod[idx][module] = cur;
	}
	
	private static void factorial() {
		for (int i = 1; i <= n; i++) {
			q *= i;
		}
	}
	
	private static long gcd(long a, long b) { 
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}
