package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12850 {

	private static int MOD = 1_000_000_007;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long[][] arr = {
//				 0  1  2  3  4  5  6  7
				{0, 1, 0, 0, 0, 0, 0, 1},
				{1, 0, 1, 0, 0, 0, 0, 1},
				{0, 1, 0, 1, 0, 0, 1, 1},
				{0, 0, 1, 0, 1, 0, 1, 0},
				{0, 0, 0, 1, 0, 1, 0, 0},
				{0, 0, 0, 0, 1, 0, 1, 0},
				{0, 0, 1, 1, 0, 1, 0, 1},
				{1, 1, 1, 0, 0, 0, 1, 0}
				
			};
		
		arr = divide(arr, n);
		System.out.println(arr[0][0]);
	}
	
	private static long[][] square(long[][] arr1, long[][] arr2) {
		long[][] newArr = new long[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					newArr[i][j] = (newArr[i][j] + (arr1[i][k] * arr2[k][j]) % MOD) % MOD; 
				}
			}
		}
		return newArr;
	}
	
	private static long[][] divide(long[][] arr, long n) {
		if (n == 1) return arr;
		if (n % 2 == 0) {
			long[][] arr1 = divide(arr, n / 2);
			return square(arr1, arr1);
		} else {
			return square(divide(arr, n - 1), arr);
		}
		
	}

}
