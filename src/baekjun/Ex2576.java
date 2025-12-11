package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		int min = 101;
		for (int i = 0; i < 7; i++) {
			int next = Integer.parseInt(br.readLine());
			if (next % 2 != 0) {
				sum += next;
				min = Math.min(next, min);
			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
