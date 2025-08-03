package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5585 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sub = 1000 - n;
		
		int answer = 0;
		
		if (sub / 500 != 0) {
			answer += sub/500;
			sub %= 500;
		}
		if (sub / 100 != 0) {
			answer += sub/100;
			sub %= 100;
		}
		if (sub / 50 != 0) {
			answer += sub/50;
			sub %= 50;
		}
		if (sub / 10 != 0) {
			answer += sub/10;
			sub %= 10;
		}
		if (sub / 5 != 0) {
			answer += sub/5;
			sub %= 5;
		}
		if (sub / 1 != 0) {
			answer += sub/1;
		}
		System.out.println(answer);
	}

}
//620 -> 500 100 10 10
//999 -> 500 100*4 50 10*4 5 1 1 1 1
