package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15990_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		long[][] d = new long[100001][4];
		
		d[1][1] = 1;
		d[2][2] = 1;
		d[3][1] = 1;
		d[3][2] = 1;
		d[3][3] = 1;
		
		for (int i = 4; i < d.length; i++) {
			d[i][3] = (d[i-3][1] + d[i-3][2]) % 1_000_000_009;
			d[i][2] = (d[i-2][1] + d[i-2][3]) % 1_000_000_009;
			d[i][1] = (d[i-1][2] + d[i-1][3]) % 1_000_000_009;
		}
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			long answer = (d[n][1] + d[n][2] + d[n][3]) % 1_000_000_009;
			System.out.println(answer);
		}
		
	}

}
