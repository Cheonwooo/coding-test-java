package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3745 {
	
	private static int n, len;
	private static int[] arr, lis;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = null;
		while ((input = br.readLine()) != null) {
			n = Integer.parseInt(input.trim());
			arr = new int[n];
			lis = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			lis[0] = arr[0];
			len = 1;
			LIS();
			
			sb.append(len + "\n");
		}
		System.out.println(sb);
	}
	
	private static void LIS() {
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			
			if (lis[len - 1] < key) {
				len++;
				lis[len - 1] = key;
			} else {
				int left = 0;
				int right = len;
				
				while (left < right) {
					int mid = (left + right) / 2;
					
					if (lis[mid] < key) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				lis[right] = key;
			}
		}
	}

}
