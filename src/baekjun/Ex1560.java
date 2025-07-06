package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex1560 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger number = new BigInteger(br.readLine());
		
		if (number.equals(BigInteger.ONE)) {
			System.out.println(BigInteger.ONE);
		} else {
			System.out.println(number.add(number).subtract(BigInteger.valueOf(2)));
		}
	}
}
