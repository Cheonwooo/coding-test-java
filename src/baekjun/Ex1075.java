package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1075 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int mod = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 100; i++) {
			String ori = input.substring(0, input.length() - 2);
			String num = String.valueOf(i);
			if (i < 10) {
				num = "0" + String.valueOf(i);
			}
			
			String number = ori + num;
			if (Integer.parseInt(number) % mod == 0) {
				System.out.println(num);
				return;
			}
		}
	}

}
