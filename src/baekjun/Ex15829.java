package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex15829 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < L; i++) {
			BigInteger mul = new BigInteger("1");
			BigInteger index = BigInteger.valueOf((long)str.charAt(i) - 96);
			sum = sum.add(index.multiply(BigInteger.valueOf(31).pow(i)));
		}
		System.out.println(sum.remainder(BigInteger.valueOf(1234567891)));
	}

}
