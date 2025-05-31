package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2805 {
	
	private static int n, m;
	private static int[] tree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[n];
		
		st = new StringTokenizer(br.readLine());
		int maxHight = 0;
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			maxHight = Math.max(maxHight, tree[i]);
		}
		
		//이분탐색
		System.out.println(binarySearch(maxHight));
	}
	
	public static int binarySearch(int maxHight) {
		int left = 0;
		int right = maxHight;
		int mid = (left + right) / 2;
		
		while (left <= right) {
			long sum = 0;
			for (int i = 0; i < n; i++) {
				int sub = tree[i] - mid;
				
				if (sub > 0) sum += sub;
			}
			
			if (sum < m) {
				right = mid - 1;
			} else if (sum > m) {
				left = mid + 1;
			} else {
				break;
			}
			
			mid = (left + right) / 2;
		}
		return mid;
	}
}
