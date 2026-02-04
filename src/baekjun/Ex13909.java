package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex13909 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int i = 1; i <= Math.sqrt(n); i++) {
			answer++;
		}
		System.out.println(answer);
	}

}
/*
 * 6
 * 1 2 3 4 5 6
 * 1 1 1 1 1 1 1
 * 1 0 1 0 1 0 2
 * 1 0 0 0 1 1 3 
 * 1 0 0 1 1 1 4
 * 1 0 0 1 0 0 5 
 * 1 0 0 1 0 1 6
 */
