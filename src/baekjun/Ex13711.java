package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13711 {
	
	private static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrA[Integer.parseInt(st.nextToken())-1] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrB[i] = arrA[Integer.parseInt(st.nextToken())-1];
		}
		
		int[] LIS = new int[n];
		
		LIS[0] = arrB[0];
		int len = 1;
		
		for (int i = 1; i < n; i++) {
			int key = arrB[i];
			
			if (LIS[len - 1] < key) { 
				len++;
				LIS[len - 1] = key;
			} else {
				int left = 0;
				int right = len;
				
				while (left < right) {
					int mid = (left + right) / 2;
					
					if (LIS[mid] < key) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				LIS[right] = key;
			}
		}
		System.out.println(len);
	}
}
