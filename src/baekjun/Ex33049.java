package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex33049 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= c; i++) {
			if ((a + i) % 3 == 0 && (b + c - i) % 4 == 0) {
				System.out.println((a + i) / 3 + " " + (b + c - i) / 4);
				return;
			}
		}
		System.out.println(-1);
	}

}
