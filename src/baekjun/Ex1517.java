package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1517 {
	
	private static long answer;
	private static int[] arr, sorted;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		sorted = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, n-1);
		
		System.out.println(answer);
	}
	
	private static void mergeSort(int left, int right) {
		if (left >= right) {
			return;
		}
		
		int mid = (left + right) / 2;
		
		mergeSort(left, mid);
		mergeSort(mid + 1, right);
		merge(left, mid, right);
	}
	
	private static void merge(int left, int mid, int right) {
		int start = left;
		int end = mid + 1;
		int index = left;
		
		while (start <= mid && end <= right) {
			if (arr[start] <= arr[end]) {
				sorted[index++] = arr[start++];
			} else {
				answer += (mid + 1 - start);
				sorted[index++] = arr[end++];
			}
		}
		
		while (start <= mid) {
			sorted[index++] = arr[start++];
		}
		while (end <= right) {
			sorted[index++] = arr[end++];
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
}
