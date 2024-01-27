package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex1676 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		long n = Integer.parseInt(br.readLine());
		
		BigInteger sum = BigInteger.valueOf(1);
		for (int i = 1; i < n+1; i++) {
			sum = sum.multiply(BigInteger.valueOf(i));
		}
		
		int count = 0;
		while (true) {
			BigInteger moq = sum.remainder(BigInteger.valueOf(10));
			
			if (moq.compareTo(BigInteger.valueOf(0)) == 1) break;
			if (sum.compareTo(BigInteger.valueOf(0)) == 0) break;
			
			count++;
			sum = sum.divide(BigInteger.valueOf(10));
		}
		System.out.println(count);
	}

}
