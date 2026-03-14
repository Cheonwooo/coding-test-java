package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex32628 {

	public static void main(String[] args) throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] sumA = new long[n+1];
		long[] sumB = new long[n+1];
		for (int i = 1; i <= n; i++) {
			sumA[i] = sumA[i-1] + a[i];
		}
		
		for (int i = 1; i <= n; i++) {
			sumB[i] = sumB[i-1] + b[i];
		}
		
		long answer = Long.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			int j = (2 * n - k) - i;
			
			if (j < 0 || j > n) continue;
			
			answer = Math.min(answer, Math.max(sumA[i], sumB[j]));
		}
		System.out.println(answer);
	}

}
