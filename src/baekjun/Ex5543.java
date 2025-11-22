package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5543 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] burger = new int[3];
		for (int i = 0; i < 3; i++) {
			burger[i] = Integer.parseInt(br.readLine());
		}
		
		int[] drink = new int[2];
		for (int i = 0; i < 2; i++) {
			drink[i] = Integer.parseInt(br.readLine());
		}
		
		int min = 10000;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				min = Math.min(min, burger[i] + drink[j] - 50);
			}
		}
		System.out.println(min);
	}

}
