package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex28357 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Long k = Long.parseLong(st.nextToken());
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		long left = 0;
		long right = arr[n-1];
		while (left <= right) {
			long mid = (left + right) / 2;
			
			long sum = 0;
			for (int i = n-1; i >= 0; i--) {
				if (mid <= arr[i]) {
					sum += arr[i] - mid;
				} else {
					break;
				}
			}
			
			if (sum > k) {
				left = mid + 1;
			} else if (sum <= k) {
				right = mid - 1;
			}
		}
		System.out.println(left);
	}

}
