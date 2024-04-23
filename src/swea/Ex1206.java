package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1206 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] d = {-2, -1, 1, 2};
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = calculateBuilderCount(arr, d, n);
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int calculateBuilderCount(int[] arr, int[] d, int n) {
		int sum = 0;
		
		for (int i = 2; i < n-2; i++) {
			int min = calculateMinCount(arr, d, i);
			
			if (min != Integer.MAX_VALUE) {
				sum += min;
			}
		}
		return sum;
	}
	
	public static int calculateMinCount(int[] arr, int[] d, int index) {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < d.length; i++) {
			int sub = arr[index] - arr[index+d[i]];
			
			if (sub < 1) {
				min = Integer.MAX_VALUE;
				break;
			}
			min = Math.min(min, sub);
		}
		return min;
	}

}
