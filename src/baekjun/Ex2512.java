package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2512 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] cost = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
			max = Math.max(max, cost[i]);
		}
		
		int limit = Integer.parseInt(br.readLine());
		if (sum <= limit) {
			System.out.println(max);
			return;
		} 
		
		int left = 0;
		int right = max;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			sum = 0;
			for (int i = 0; i < n; i++) {
				if (cost[i] <= mid) {
					sum += cost[i];
				} else {
					sum += mid;
				}
			}
			
			if (sum < limit) {
				left = mid + 1;
			} else if (sum > limit) {
				right = mid - 1;
			} else {
				System.out.println(mid);
				return;
			}
		}
		System.out.println((left + right) / 2);
	}
}
