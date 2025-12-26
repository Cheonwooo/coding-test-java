package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Ex13706 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger number = new BigInteger(br.readLine());
		
		BigInteger answer = number.sqrt();
		System.out.println(answer);
	}

}
