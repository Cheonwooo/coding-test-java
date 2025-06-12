package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10830 {
	
	private static int n;
	private static long b;
	private static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] result = pow(arr, b);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int[][] pow(int[][] temp, long exp) {
		if (exp == 1) {
			return temp;
		}
		
		int[][] result = pow(temp, exp / 2);
		
		result = multiply(result, result);
		
		if (exp % 2 == 1) {
			result = multiply(result, arr);
		}
		return result;
	}
	
	private static int[][] multiply(int[][] arr1, int[][] arr2) {
		int[][] result = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
					result[i][j] %= 1000;
				}
			}
		}
		
		return result;
	}
}