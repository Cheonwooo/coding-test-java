package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex30890 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int lcm = lcm(x, y);
		
		int leftRythm = lcm / x;
		int rightRythm = lcm / y;
		
		for (int i = 1; i <= lcm; i++) {
			if (i % leftRythm == 0 && i % rightRythm != 0) {
				System.out.print(1);
			} else if (i % leftRythm != 0 && i % rightRythm == 0) {
				System.out.print(2);
			} else if (i % leftRythm == 0 && i % rightRythm == 0) {
				System.out.print(3);
			}
		}
	}
	
	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}
