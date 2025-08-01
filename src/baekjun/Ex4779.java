package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex4779 {
	
	private static char[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while ((input = br.readLine()) != null) {
			int n = Integer.parseInt(input);
			int init = (int)Math.pow(3, n);
			arr = new char[init];
			Arrays.fill(arr, '-');
			
			divide(0, init);
			System.out.println(new String(arr));
		}
	}
	
	private static void divide(int start, int end) {
		if (end == 1) return;
		end /= 3;
		for (int i = start + end; i < start + 2 * end; i++) {
			arr[i] = ' ';
		}
		
		divide(start, end);
		divide(start + 2 * end, end);
	}
}
