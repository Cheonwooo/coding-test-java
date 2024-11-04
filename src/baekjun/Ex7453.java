package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 메모리 152540kb, 시간 4164ms

public class Ex7453 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sumAB = new int[n*n];
		int[] sumCD = new int[n*n];
		
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sumAB[index] = a[i] + b[j];
				sumCD[index++] = c[i] + d[j];
			}
		}
		
		Arrays.sort(sumAB);
		Arrays.sort(sumCD);
		
		long answer = 0;
		int left = 0;
		int right = sumCD.length - 1;
		while (left < sumAB.length && right >= 0) {
			int sum = sumAB[left] + sumCD[right];

			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			} else {//sum == 0
				long leftCount = 1;
				long rightCount = 1;
				
				while (left < sumAB.length-1 && (sumAB[left] == sumAB[left+1])) {
					leftCount++;
					left++;
				}
				
				while (right > 0 && (sumCD[right] == sumCD[right-1])) {
					rightCount++;
					right--;
				}
				answer += leftCount * rightCount;
				left++;
			}
		}
		System.out.println(answer);
	}
}
