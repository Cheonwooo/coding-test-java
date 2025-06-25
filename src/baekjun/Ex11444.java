package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11444 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long[][] arr = {{1,1}, {1,0}};
		long[][] A = {{1,0}, {0,1}};
		
		if (n == 1 || n == 0) {
			System.out.println(n);
			return;
		}
		
		n--;
		
		while (n > 0) {
			if (n % 2 == 1) {
				A = mul(A, arr);
			}
			arr = mul(arr, arr);
			
			n /= 2;
		}
		
		System.out.println(A[0][0]);
	}
	
	private static long[][] mul(long[][] arr1, long[][] arr2) {
		long[][] temp = new long[2][2];
		
		temp[0][0] = ((arr1[0][0] * arr2[0][0]) + (arr1[0][1] * arr2[1][0])) % 1_000_000_007;
		temp[0][1] = ((arr1[0][0] * arr2[0][1]) + (arr1[0][1] * arr2[1][1])) % 1_000_000_007;
		temp[1][0] = ((arr1[1][0] * arr2[0][0]) + (arr1[1][1] * arr2[1][0])) % 1_000_000_007;
		temp[1][1] = ((arr1[1][0] * arr2[0][1]) + (arr1[1][1] * arr2[1][1])) % 1_000_000_007;

		return temp;
	}
}
