package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex29766 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int answer = 0;
		for (int i = 0; i < str.length() - 3; i++) {
			String subStr = str.substring(i, i+4);
			if (subStr.equals("DKSH")) answer++;
		}
		
		System.out.println(answer);
	}

}
