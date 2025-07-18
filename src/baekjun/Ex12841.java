package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12841 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] crossWalk = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int dist = Integer.parseInt(st.nextToken());
			crossWalk[i] = dist;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n-1; i++) {
			int dist = Integer.parseInt(st.nextToken());
			left[i] = dist;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n-1; i++) {
			int dist = Integer.parseInt(st.nextToken());
			right[i] = dist;
		}
		
		long max = Long.MAX_VALUE;
		int road = 0;
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = 0; j < i; j++) {//left
				sum += left[j];
			}
			sum += crossWalk[i];
			for (int j = i; j < n-1; j++) {//right
				sum += right[j];
			}
			
			if (max > sum) {
				road = i+1;
				max = sum;
			}
		}
		
		System.out.println(road + " " + max);
	}
}
