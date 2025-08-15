package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex31534 {
	
	private static double PI = 3.14159265;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		double h = Double.parseDouble(st.nextToken());
		
		if (a == b) {
			System.out.println(-1);
			return;
		}
		
		if (a < b) {
			double temp = a;
			a = b;
			b = temp;
		}
		
		double H = a * h / (b - a);
		
		double bigArea = Math.pow(H + h, 2) + Math.pow(b, 2);
		double smallArea = (a != 0) ? Math.pow(H, 2) + Math.pow(a, 2) : 0;
		
		double answer = Math.abs((bigArea - smallArea) * PI);
		System.out.println(answer);
	}

}
