package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1999 {
	
	private static int n, b;
	private static int[][] arr, savedArr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		savedArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeSavedArr();
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			sb.append(savedArr[x][y] + "\n");
		}
		System.out.println(sb);
	}
	
	private static void makeSavedArr() {
		for (int i = 0; i < n - b + 1; i++) {
			for (int j = 0; j < n - b + 1; j++) {
				int min = Integer.MAX_VALUE;
				int max = 0;
				for (int m = i; m < i + b; m++) {
					for (int n = j; n < j + b; n++) {
						min = Math.min(arr[m][n], min);
						max = Math.max(arr[m][n], max);
					}
				}
				savedArr[i][j] = max - min;
			}
		}
	}
}
