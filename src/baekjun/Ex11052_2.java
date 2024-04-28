package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11052_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cardPrice = new int[n+1];
		int[] d = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cardPrice[i] = Integer.parseInt(st.nextToken());
		}
		
		d[1] = cardPrice[1];
		
		for (int i = 2; i <= n; i++) {
			d[i] = cardPrice[i];
			for (int j = 1; j < i; j++) {
				d[i] = Math.max(d[i], d[i-j] + d[j]);
			}
		}
		System.out.println(d[n]);
	}

}
