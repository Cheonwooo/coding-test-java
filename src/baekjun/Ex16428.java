package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ex16428 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		BigInteger A = new BigInteger(a);
		BigInteger B = new BigInteger(b);
		
		if (A.compareTo(BigInteger.ZERO) == -1 && B.compareTo(BigInteger.ZERO) == -1) {
			System.out.println((A.divide(B)).add(BigInteger.ONE));
			System.out.println((A.remainder(B)).subtract(B));
		} else if (A.compareTo(BigInteger.ZERO) == -1 && B.compareTo(BigInteger.ZERO) == 1) {
			System.out.println((A.divide(B)).subtract(BigInteger.ONE));
			System.out.println((A.remainder(B)).add(B));
		} else {
			System.out.println(A.divide(B));
			System.out.println(A.remainder(B));
		}
	}

}
