package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1929_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = m; i <= n; i++) {
			if (i == 1) continue;
			
			boolean check = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					check = false;
					break;
				}
			}
			if (check) sb.append(i + "\n"); 
		}
		System.out.println(sb);
	}

}
