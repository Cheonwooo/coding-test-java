package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex28115 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		if (n == 1) {
			System.out.println("YES");
			System.out.println(arr[0] * 2);
			System.out.println(-arr[0]);
		} else {
			long sub = arr[1] - arr[0];

			for (int i = 0; i < n-1; i++) {
				if ((arr[i+1] - arr[i]) != sub) {
					System.out.println("NO");
					return;
				}
			}
			
			long[] b = new long[n];
			long[] c = new long[n];
			
			for (int i = 1; i < n+1; i++) {
				c[i-1] = -sub * i;
				b[i-1] = arr[i-1] - c[i-1]; 
			}
			
			System.out.println("YES");
			for (long num : b) {
				System.out.print(num + " ");
			}
			System.out.println();
			for (long num : c) {
				System.out.print(num + " ");
			}
		}
		
	}

}
