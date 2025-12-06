package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2490 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int back = 0;
			int front = 0;
			for (int j = 0; j < 4; j++) {
				int next = Integer.parseInt(st.nextToken());
				
				if (next == 1) back++;
				else front++;
			}
			
			if (front == 0) {
				System.out.println("E");
			} else if (front == 1) {
				System.out.println("A");
			} else if (front == 2) {
				System.out.println("B");
			} else if (front == 3) {
				System.out.println("C");
			} else {
				System.out.println("D");
			}
		}
	}

}
