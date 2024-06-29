package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1959 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			sb.append("#" + (i+1) + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arrA = new int[n];
			int[] arrB = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arrA[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arrB[j] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			if (arrA.length <= arrB.length) {
				answer = calculateSum(arrA, arrB);
			} else {
				answer = calculateSum(arrB, arrA);
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int calculateSum(int[] arrA, int[] arrB) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= arrB.length - arrA.length; i++) {
			int sum = 0;
			for (int j = 0; j < arrA.length; j++) {
				sum += arrB[i+j] * arrA[j];
			}
			max = Math.max(max, sum);
		}
		return max;
		
	}

}
