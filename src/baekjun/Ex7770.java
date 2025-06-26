package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex7770 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int init = 1;
		int start = 1;
		int answer = 1;
		while (true) {
			init += answer * 4;
			start += init;
			if (start > n) break;
			answer++;
		}
		System.out.println(answer);
	}

}

/*
 * 1 1
 * 5 6
 * 13 19
 * 25 44
 * 
 * 4 8 12
 */