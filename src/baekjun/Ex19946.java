package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex19946 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger num = new BigInteger(br.readLine());
		
		int answer = 64;
		while (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) { 
			num = num.divide(BigInteger.TWO);
			answer--;
		}
		System.out.println(answer);
	}

}
