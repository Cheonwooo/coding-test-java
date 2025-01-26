package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 메모리 57024kb, 시간 724kb

public class Ex15824 {
	
	private static int n;
	private static long answer;
	private static int[] arr;
	private static long[] temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		temp = new long[n+1];
		
		temp[0] = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			temp[i] = (temp[i-1] * 2) % 1_000_000_007;
		}
		
		Arrays.sort(arr);
		
		for (int i = 1; i <= n; i++) {
			answer = (answer + (temp[i-1] - temp[n-i]) * arr[i]) % 1_000_000_007;
		}
		
		System.out.println(answer);
	}
}
