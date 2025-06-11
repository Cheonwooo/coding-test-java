package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex31995 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int count = 0;
		
		if (m > n) {
			int temp = n;
			n = m;
			m = temp;
		}
		
		if (m == 1) System.out.println(0);
		else {
			for (int i = 0; i < n-1; i++) {
				for (int j = 0; j < m; j++) {
					if (j == 0 || j == m-1) { 
						count+=1;
					} else {
						count+=2;
					}
				}
			}
			System.out.println(count);
		}
	}

}
