package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1019 {
	
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int start = 1;
		int mul = 1;
		
		arr = new int[10];
		
		while (start <= n) {
			while (start % 10 != 0 && start <= n) {
				countArr(start, mul);
				start++;
			}
			
			while (n % 10 != 9 && start <= n) {
				countArr(n, mul);
				n--;
			}
			
			if (start > n) break;
			
			start /= 10;
			n /= 10;
			
			for (int i = 0; i < 10; i++) {
				arr[i] += (n - start + 1) * mul;
			}
			
			mul *= 10;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static void countArr(int num, int mul) {
		while (num > 0) {
			arr[num % 10] += mul;
			num /= 10;
		}
	}
}
