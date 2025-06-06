package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1259 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			String answer = "yes";
			
			if (str.equals("0")) break;
			
			for (int i = 0; i < str.length()/2; i++) {
				if (str.charAt(i) != str.charAt(str.length()-1-i)) {
					answer = "no";
					break;
				}
			}
			System.out.println(answer);
		}
	}

}
