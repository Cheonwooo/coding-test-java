package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2467 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[2];
		int left = 0;
		int right = arr.length - 1;
		int min = Integer.MAX_VALUE;
		while (left < right) {
			int sum = arr[left] + arr[right];
			int absSum = Math.abs(sum);
			
			if (absSum < min) {
				answer[0] = arr[left];
				answer[1] = arr[right];
				min = absSum;
			}
			
			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}
}
