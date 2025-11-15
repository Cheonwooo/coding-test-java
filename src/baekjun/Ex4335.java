package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4335 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] check = new boolean[11];
		while (true) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0) break;
			
			String str = br.readLine();
			if (str.equals("too high")) {
				for (int i = number; i <= 10; i++) {
					check[i] = true;
				}
			} else if (str.equals("too low")) {
				for (int i = number; i >= 0; i--) {
					check[i] = true;
				}
			} else {
				if (check[number]) {
					System.out.println("Stan is dishonest");
				} else {
					System.out.println("Stan may be honest");
				}
				check = new boolean[11];
			}
		}
	}

}
