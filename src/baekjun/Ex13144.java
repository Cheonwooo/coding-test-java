package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13144 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] num = new int[100001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		int left = 0;
		int right = 0;
		while (left < n) {
			while (right < n && num[arr[right]] == 0) {
				num[arr[right]]++;
				right++;
			}
			answer += right - left;
			num[arr[left]]--;
			left++;
		}
		System.out.println(answer);
	}

}
