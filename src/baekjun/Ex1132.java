package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex1132 {
	
	private static class Number implements Comparable<Number> {
		int index;
		long num;

		public Number(int index, long num) {
			this.index = index;
			this.num = num;
		}
		
		public int compareTo(Number o) {
			if (this.num == o.num) {
				return Integer.compare(this.index, o.index);
			}
			return Long.compare(this.num, o.num);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boolean[] firstNum = new boolean[27];
		long[] arr = new long[27];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < input.length; j++) {
				if (j == 0) {
					firstNum[input[j] - 'A'] = true;
				}
				arr[input[j] - 'A'] += Math.pow(10, input.length-1-j);
			}
		}
		
		int usedCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				usedCount++;
			}
		}
		if (usedCount >= 10) {
			List<Number> list = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (!firstNum[i] && arr[i] != 0) {
					list.add(new Number(i, arr[i]));
				}
			}
			
			if (!list.isEmpty()) {
				Collections.sort(list);
				int zeroIndex = list.get(0).index;
				arr[zeroIndex] = 0;
			}
		}
		
		Arrays.sort(arr);
		
		long answer = 0;
		int index = 9;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (index == -1) break;
			answer += arr[i] * index--;
		}
		System.out.println(answer);
	}

}
