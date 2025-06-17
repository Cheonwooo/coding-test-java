package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9215 {
	
	private static int child, parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) break;
			
			sb.append("Test " + count++ + ": ");
			
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split("/");
				
				int numer = 0;
				int denomin = 0;
				if (input.length == 1) {
					denomin = 1;
				} else {
					denomin = Integer.parseInt(input[1]);
				}
				
				if (input[0].contains(",")) {
					String[] numers = input[0].split(",");
					
					numer += Integer.parseInt(numers[0]) * denomin + Integer.parseInt(numers[1]);
				} else {
					numer = Integer.parseInt(input[0]);
				}
				int euclid = gcd(numer, denomin);
				
				numer /= euclid;
				denomin /= euclid;
				
				if (i == 0) {
					child = numer;
					parent = denomin;
				} else {
					calculateSum(numer, denomin);
				}
//				System.out.println(numer + " " + denomin + " " + child + " " + parent);
			}
			
			if (parent == 1) {
				sb.append(child + "\n");
			} else if (child == 0 && parent == 0) {
				sb.append(0 + "\n");
			} else {
				if ((child / parent) > 0) {
					sb.append((child/parent) + "," + (child%parent) + "/" + parent + "\n");
				} else {
					sb.append(child + "/" + parent + "\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	private static int gcd (int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
	
	private static void calculateSum(int numer, int denomin) {
		child = child * denomin + numer * parent;
		parent *= denomin;
		
		int euclid = gcd(parent, child);
		
		child /= euclid;
		parent /= euclid;
	}
}
