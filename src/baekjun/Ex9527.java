package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex9527 {
	
	private static long[] dp = new long[64];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		dp[0] = 1;
		for (int i = 1; i < 64; i++) {
			dp[i] = (dp[i-1] << 1) + (1L << i); 
		}
		
		long answer = calculateCount(b) - calculateCount(a-1);
		System.out.println(answer);
	}
	
	private static long calculateCount(long num) {
		long count = num & 1;
		int size = (int) (Math.log(num) / Math.log(2));
		for (int i = size; i > 0; i--) {
			if ((num & (1L << i)) != 0L) {
				count += dp[i-1] + (num - (1L << i) + 1);
				num -= (1L << i);
			}
		}
		return count;
	}
}
