package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex28081 {
	
	private static int w, h, n ,m;
	private static long k;
	private static long[] xLen, yLen;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		
		n = Integer.parseInt(br.readLine());
		int[] x = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		xLen = new long[n+2]; 
		for (int i = 1; i < n+1; i++) {
			if (i == n) {
				int len = x[i]; 
				xLen[i] = len - x[i-1];
				xLen[i + 1] = h - len;
			} else {
				xLen[i] = x[i] - x[i-1];
			}
		}
		
		m = Integer.parseInt(br.readLine());
		int[] y = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < m+1; i++) {
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		yLen = new long[m+2]; 
		for (int i = 1; i < m+1; i++) {
			if (i == m) {
				int len = y[i]; 
				yLen[i] = len - y[i-1];
				yLen[i + 1] = w - len;
			} else {
				yLen[i] = y[i] - y[i-1];
			}
		}

		Arrays.sort(xLen);
		long answer = 0;
		for (int i = 1; i < m+2; i++) {
			answer += findIndex(i);
		}
		System.out.println(answer);
	}
	
	private static int findIndex(int idx) {
		int left = 1;
		int right = n+2;
		boolean check = false;
		
		int mid = 0;
		long len = yLen[idx];
		while (left < right) {
			mid = (left + right) / 2;
			long area = xLen[mid] * len;
			if (area > k) {
				right = mid;
			} else {
				check = true;
				left = mid + 1;
			}
		}
		if (!check) return 0;
		return left - 1;
	}
}
