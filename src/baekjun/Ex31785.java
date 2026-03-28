package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex31785 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[500_001];
		int totalSum = 0;
		int left = 0;
		int right = -1;
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			int query = Integer.parseInt(st.nextToken());
			if (query == 1) {
				int x = Integer.parseInt(st.nextToken());
				totalSum += x;
				arr[++right] = x;
			} else {
				int n = right - left + 1;
				
				int preSum = 0;
				for (int j = 0; j < n/2; j++) {
					preSum += arr[left + j];
				}
				int nextSum = totalSum - preSum;
				
				if (preSum <= nextSum) {
					System.out.println(preSum);
					left += n/2;
					totalSum -= preSum;
				} else {
					System.out.println(nextSum);
					right -= (n - n/2);
					totalSum -= nextSum;
				}
			}
		}
		for (int i = left ; i <= right; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
/**
 * left, right
 * n = 5, 앞 : < 2/n
 * 전체합, left ~ right까지 합
 * query == 2일 때, left ~ right 까지 합 출력
 * 5일 때 1~2 버림, 3~5남음
 * 3 4 1 2 3
 * i~j까지의 합은 sum[j] = sum[i-1]임 이걸 이용
 */
