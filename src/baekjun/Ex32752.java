package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex32752 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken())-1;
		int r = Integer.parseInt(st.nextToken())-1;
		int[] arr = new int[n];
		int[] sortedArr = new int[r-l+1];
		
		int index = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i >= l && i <= r) {
				sortedArr[index++] = arr[i];
			}
		}
		
		Arrays.sort(sortedArr);
		index = 0;
		for (int i = l; i <= r; i++) {
			arr[i] = sortedArr[index++];
		}
		
		for (int i = 0; i < n-1; i++) {
			if (arr[i] > arr[i+1]) {
				System.out.println("0");
				return;
			}
		}
		System.out.println(1);
		
	}

}
