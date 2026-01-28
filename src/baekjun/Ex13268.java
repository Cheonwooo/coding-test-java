package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13268 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		n %= 100;
		if (n <= 10) {
			if (n == 0 || n == 10) {
				System.out.println(0);
			} else if (0 < n && n < 10) {
				System.out.println(1);
			}
		} else if (10 < n && n <= 30) { 
			if (n == 30) {
				System.out.println(0);
			} else if (10 < n && n <= 15) {
				System.out.println(1);
			} else if (15 < n && n < 25) {
				System.out.println(2);
			} else if (25 <= n && n < 30) {
				System.out.println(1);
			}
		} else if (30 < n && n <= 60) { 
			if (n == 60) {
				System.out.println(0);
			} else if (30 < n && n <= 35) {
				System.out.println(1);
			} else if (35 < n && n <= 40) {
				System.out.println(2);
			} else if (40 < n && n < 50) {
				System.out.println(3);
			} else if (50 <= n && n < 55) {
				System.out.println(2);
			} else if (55 <= n && n < 60) {
				System.out.println(1);
			}
		} else {//61 < n && n <= 100
			if (60 < n && n <= 65) {
				System.out.println(1);
			} else if (65 < n && n <= 70) {
				System.out.println(2);
			} else if (70 < n && n <= 75) {
				System.out.println(3);
			} else if (75 < n && n < 85) {
				System.out.println(4);
			} else if (85 <= n && n < 90) {
				System.out.println(3);
			} else if (90 <= n && n < 95) {
				System.out.println(2);
			} else if (95 <= n && n < 100) {
				System.out.println(1);
			}
		}
	}

}
