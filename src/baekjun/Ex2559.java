package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2559 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int sum = 0;
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (count < k) {
				sum += arr[i];
				count++;
			}
		}

		int answer = sum;
		int left = 0;
		int right = k;
		while (right < n) {
			sum = sum - arr[left++] + arr[right++];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
