package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex2935 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger numA = new BigInteger(br.readLine());
		String calculator = br.readLine();
		BigInteger numB = new BigInteger(br.readLine());
		
		if (calculator.equals("*")) {
			System.out.println(numA.multiply(numB));
		} else {
			System.out.println(numA.add(numB));
		}
	}

}
