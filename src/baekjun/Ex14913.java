package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14913 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if (a == c) {
			System.out.println(1);
			return;
		}
		int index = 1;
		while (a > -1000000 && a < 1000000) {
			a += b;
			index++;
			if ((a != -1000000 || a != 1000000) && a == c) {
				System.out.println(index);
				return;
			}
		}
		System.out.println("X");
		
		
	}

}
