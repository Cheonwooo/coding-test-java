package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9663 {
	
	private static int n, count;
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		nqueen(0);
		System.out.println(count);
	}
	
	private static void nqueen(int depth) {
		if (depth == n) {
			count++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if (possible(depth)) {
				nqueen(depth+1);
			}
		}
	}
	
	private static boolean possible(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}

}
