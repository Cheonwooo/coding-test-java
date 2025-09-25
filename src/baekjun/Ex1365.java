package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1365 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] LIS = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = arr[0];
		int len = 1;
		
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			
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
		System.out.println(n - len);
	}

}
