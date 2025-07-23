package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19563 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Math.abs(Integer.parseInt(st.nextToken()));
		int b = Math.abs(Integer.parseInt(st.nextToken()));
		int c = Integer.parseInt(st.nextToken());
		
		if (c == 0 && (a != 0 || b != 0)) {
			System.out.println("NO");
			return;
		}
		
		int sum = (a + b);
		
		if (sum <= c) {
			if (sum % 2 == 0 && c % 2 == 0) {
				System.out.println("YES");
			} else if (sum % 2 != 0 && c % 2 != 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			System.out.println("NO");
		}
	}
}
