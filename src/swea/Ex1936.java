package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1936 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if (A == 1) {
			if (B == 2) System.out.println("B");
			else if (B == 3) System.out.println("A");
		} else if (A == 2) {
			if (B == 1) System.out.println("A");
			else if (B == 3) System.out.println("B");
		} else {
			if (B == 1) System.out.println("B");
			else if (B == 2) System.out.println("A");
		}
	}
}
