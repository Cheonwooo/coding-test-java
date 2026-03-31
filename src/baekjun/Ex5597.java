package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5597 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] check = new boolean[31];
		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(br.readLine());
			check[num] = true;
		}
		
		for (int i = 1; i < 31; i++) {
			if (!check[i]) {
				System.out.println(i);
			}
		}
	}

}
