package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17177 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int p = a;
		int q = 2 * b * c;
		int r = a * (c*c - a*a + b*b);
		
		int d = q * q - 4 * p * r;
		if (d < 0) {
			System.out.println(-1);
		} else {
			double x = (Math.sqrt(d) + (-q)) / (2 * p);
			
			if (x < 0) {
				System.out.println(-1);
			} else {
				System.out.println((int)(x + 1e-5));
			}
		}
	}

}
