package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex27922 {

	private static int n, k, answer;
	private static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[3][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[0][i] = a + b;
			arr[1][i] = b + c;
			arr[2][i] = c + a;
		}
		
		for (int i = 0; i < 3; i++) {
			Arrays.sort(arr[i]);
		}
		
		int[] sum = new int[3];
		for (int i = n-1; i >= n-k; i--) {
			sum[0] += arr[0][i];
			sum[1] += arr[1][i];
			sum[2] += arr[2][i];
		}
		
		answer = Math.max(sum[0], Math.max(sum[1], sum[2]));
		System.out.println(answer);
	}
}
