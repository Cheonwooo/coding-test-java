package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex21967 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[11];
		int start = 0;
		int answer = 0;
		
		for (int end = 0; end < n; end++) {
			count[arr[end]]++;
			
			while (!isValid(count)) {
				count[arr[start]]--;
				start++;
			}
			
			answer = Math.max(answer, end - start + 1);
		}
		System.out.println(answer);
	}

	private static boolean isValid(int[] count) {
		int max = 0;
		int min = 11;
		
		for (int i = 1; i <= 10; i++) {
			if (count[i] > 0) {
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
		}
		
		return (max == 0) || ((max - min) <= 2);
	}
}
