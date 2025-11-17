package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10101 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int sum = a + b + c;
		
		if (a == 60 && b == 60 && c == 60) {
			System.out.println("Equilateral");
		} else if (sum == 180) {
			if (a == b || b == c || a == c) {
				System.out.println("Isosceles");
			} else if (a != b && b != c && a != c) {
				System.out.println("Scalene");
			}
		} else if (sum != 180) {
			System.out.println("Error");
		}
	}

}
