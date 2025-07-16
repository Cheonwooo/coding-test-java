package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19939 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int sum = k * (k + 1) / 2;
		if (n < sum) {
			System.out.println(-1);
			return;
		}
		
		int dif = k-1;
		if ((n - sum) % k != 0) {
			dif++;
		}
		System.out.println(dif);
	}
}
