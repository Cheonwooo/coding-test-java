package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex27434 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		if (n == 0) {
			System.out.println(1);
		} else {
			System.out.println(factorial(1, n));
		}
	}
	
	private static BigInteger factorial(int a, int b) {
		if (a == b) return BigInteger.valueOf(b);
		
		return factorial(a, (a + b) / 2).multiply(factorial((a + b) / 2 + 1, b)); 
	}

}
