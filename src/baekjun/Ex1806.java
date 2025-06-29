package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		long ps = 0;
		while (left <= right && right <= n) {
			if (ps < s) {
				ps += arr[right++];
			} else {
				min = Math.min(min, right - left);
				ps -= arr[left++];
			}
		}
		min = (min == Integer.MAX_VALUE ? 0 : min);
		System.out.println(min);
	}
}