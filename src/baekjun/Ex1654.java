package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1654 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		
		long max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long left = 0;
		long right = max+1;
		
		while (left < right) {//이분탐색
			long mid = (left + right) / 2;
			
			long sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += (arr[i] / mid);
			}
			
			if (sum < n) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left - 1);
	}
}

