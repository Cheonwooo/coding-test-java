package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ex3724 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			long[][] arr = new long[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Long.parseLong(st.nextToken());
				}
			}
			int answer = 1;
			
			int init = 0;
			BigInteger max = BigInteger.ONE;
			for (int i = 0; i < m; i++) {
				BigInteger total = BigInteger.ONE;
				for (int j = 0; j < n; j++) {
					total = total.multiply(BigInteger.valueOf(arr[j][i]));
				}

				if (init == 0) {
					max = total;
					init = 1;
				} else {
					int compare = max.compareTo(total); 
					if (compare <= 0) {
						answer = i+1;
						max = total;
					}
				}
				
			}
			
			System.out.println(answer);
		}
	}

}
