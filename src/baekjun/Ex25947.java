package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex25947 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 0;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (a > 0) {//할인된 가격으로 먼저 구매
				sum += arr[i] / 2;
				a--;
				if (sum > b) {
					System.out.println(right);
					return;
				}
				right++;
			} else {
				sum += arr[left] / 2;
				sum += arr[right] / 2;
				
				if (sum > b) {
					System.out.println(right);
					return;
				}
				left++;
				right++;
			}
		}
		System.out.println(right);
	}

}
