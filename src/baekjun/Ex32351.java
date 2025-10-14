package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex32351 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		double s = Double.parseDouble(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int start = 1;
		double answer = 0;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			double bpm = Double.parseDouble(st.nextToken());
			
			int totalN = m - start;
			answer += (double)4/(s/60) * totalN;

			s = bpm;
			start = m;
		}
		int totalN = n - start + 1;
		answer += (double)4/(s/60) * totalN;
		
		System.out.printf("%.12f", answer);
	}

}
