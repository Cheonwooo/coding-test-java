package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13458 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long count = 0;
		for (int i = 0; i < n; i++) {
			count++;
			arr[i] -= b;
			
			if (arr[i] > 0) {
				if (arr[i] % c ==0 ) {
					count += arr[i] / c;
				} else {
					count += arr[i] / c + 1;
				}
			}
		}
		System.out.println(count);
	}

}
