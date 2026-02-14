package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex16472 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		
		int[] arr = new int[27];
		int left = 0;
		int right = 0;
		int max = 0;
		int count = 0;
		
		while (right < input.length) {
			arr[input[right] - 'a']++;
			if (arr[input[right++] - 'a'] == 1) {
				count++;
			}
			
			while (count > n && left < right) {
				arr[input[left] - 'a']--;
				if (arr[input[left] - 'a'] == 0) {
					count--;
				}
				left++;
			}
			max = Math.max(max, right - left);
		}
		System.out.println(max);
	}
}
