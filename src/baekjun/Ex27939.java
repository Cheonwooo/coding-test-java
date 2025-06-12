package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex27939 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] breed = new char[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			breed[i] = st.nextToken().charAt(0);
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean white = false;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int count = 0;
			for (int j = 0; j < k; j++) {
				if(breed[Integer.parseInt(st.nextToken())] == 'W') {
					count++;
				}
			}
			
			if (count == k) {
				white = true;
			}
		}
		if (white) System.out.println("W");
		else System.out.println("P");
	}

}
