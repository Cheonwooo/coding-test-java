package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1748_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int index = 1;
		int num = 10;
		
		for (int i = 1; i <= n; i++) {
			if (i % num == 0) {
				index++;
				num *= 10;
			}
			answer += index;
		}
		System.out.println(answer);
	}

}
