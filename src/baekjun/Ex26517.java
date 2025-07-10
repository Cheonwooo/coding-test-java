package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ex26517 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger k = new BigInteger(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		BigInteger c = new BigInteger(st.nextToken());
		BigInteger d = new BigInteger(st.nextToken());
		
		BigInteger fa = k.multiply(a).add(b);
		BigInteger fb = k.multiply(c).add(d);
		
		if (fa.equals(fb)) {
			System.out.println("Yes " + fa);
		} else {
			System.out.println("No");
		}
	}

}
