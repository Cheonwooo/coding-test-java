package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex27952 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] limit = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		int[] weight = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			
			sum += weight[i];
			if (sum < limit[i]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println((sum - limit[n-1]) / x);
		
//		int answer = 0;
//		for (int i = 0; i < n-1; i++) {
//			sum += weight[i];
//			
//			if (sum - x + weight[i+1] >= limit[i+1]) {
//				answer++;
//				sum -= x;
//			}
//		}
//		if (answer == 0) {
//			System.out.println(-1);
//		} else {
//			System.out.println(answer);
//		}
	}

}
