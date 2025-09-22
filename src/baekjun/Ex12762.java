package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12762 {
	
	private static int n, len, answer;
	private static int[] arr, lis1, lis2;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		lis1 = new int[n];
		lis2 = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		len = 1;
		leftToRightUp(0);
		answer = Math.max(answer, len);
		
		len = 1;
		rightToLeftUp(n-1);
		answer = Math.max(answer,  n - len - 1);
		
		for (int i = 1; i < n-1; i++) {
			int sum = 0;
			len = 1;
			leftToRightUp(i);
			sum += len;
			
			len = 1;
			rightToLeftUp(i);
			sum += n - len - 1;
			answer = Math.max(answer, sum-1);
		}
		System.out.println(answer);
	}
	
	private static void leftToRightUp(int start) {
		lis1 = new int[n];
		lis1[0] = arr[start];
		len = 1;
		
		for (int i = start+1; i < n; i++) {
			int key = arr[i];
			
			if (lis1[len-1] < key) {
				len++;
				lis1[len - 1] = key;
			} else {
				int left = 0;
				int right = len;
				
				while (left < right) {
					int mid = (left + right) / 2;
					
					if (lis1[mid] < key) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				lis1[left] = key;
			}
		}
	}
	
	private static void rightToLeftUp(int start) {
		lis2 = new int[n];
		lis2[n-1] = arr[start];
		len = n-2;
		for (int i = start-1; i >= 0; i--) {
			int key = arr[i];

			if (lis2[len + 1] < key) {
				len--;
				lis2[len + 1] = key;
			} else {
				int left = len;
				int right = n-1;
				
				while (left < right) {
					int mid = (left + right) / 2 + 1;

					if (lis2[mid] < key) {
						right = mid - 1;
					} else {
						left = mid;
					}
				}
				lis2[right] = key;
			}
		}
	}
}
