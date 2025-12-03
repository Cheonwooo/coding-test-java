package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex34052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int time = Integer.parseInt(br.readLine());
			sum += time;
		}
		
		if (sum <= 1500) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
