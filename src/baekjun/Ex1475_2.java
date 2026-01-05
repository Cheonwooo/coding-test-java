package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1475_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '9') {
				arr[6]++;
			} else {
				arr[input[i] - '0']++;
			}
		}
		
		if (arr[6] / 2 != 0) {
			if (arr[6] % 2 == 0) {
				arr[6] /= 2;
			} else {
				arr[6] = arr[6] / 2 + 1;
			}
		}

		int answer = 0;
		for (int num : arr) {
			answer = Math.max(answer, num);
		}
		System.out.println(answer);
	}

}
