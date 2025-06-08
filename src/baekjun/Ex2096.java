package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2096 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] maxArr = new int[n][3];
		int[][] minArr = new int[n][3];
		
		for (int i = 0; i < 3; i++) {
			maxArr[0][i] = minArr[0][i] = arr[0][i];
		}
		
		for (int i = 1; i < n; i++) { 
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					maxArr[i][j] = Math.max(maxArr[i-1][0] + arr[i][0], maxArr[i-1][1] + arr[i][0]);
					minArr[i][j] = Math.min(minArr[i-1][0] + arr[i][0], minArr[i-1][1] + arr[i][0]);
				} else if (j == 1) {
					maxArr[i][j] = Math.max(Math.max(maxArr[i-1][0] + arr[i][j], maxArr[i-1][1] + arr[i][j]), maxArr[i-1][2] + arr[i][j]);
					minArr[i][j] = Math.min(Math.min(minArr[i-1][0] + arr[i][j], minArr[i-1][1] + arr[i][j]), minArr[i-1][2] + arr[i][j]);
				} else {
					maxArr[i][j] = Math.max(maxArr[i-1][1] + arr[i][j], maxArr[i-1][2] + arr[i][j]);
					minArr[i][j] = Math.min(minArr[i-1][1] + arr[i][j], minArr[i-1][2] + arr[i][j]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, maxArr[n-1][i]);
			min = Math.min(min, minArr[n-1][i]);
		}
		
		System.out.println(max + " " + min);
	}

}
