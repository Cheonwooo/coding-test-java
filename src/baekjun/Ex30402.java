package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex30402 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 15; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 15; j++) {
				char next = st.nextToken().charAt(0);
				
				if (next == 'w') {
					System.out.println("chunbae");
					return;
				}
				if (next == 'b') {
					System.out.println("nabi");
					return;
				}
				if (next == 'g') {
					System.out.println("yeongcheol");
					return;
				}
			}
		}
	}

}
