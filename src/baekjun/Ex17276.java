package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17276 {
	
	private static int n;
	private static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (d > 0) {
				rotate(d);
			} else {
				reverseRotate(-d);
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(arr[i][j] + " " );
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void rotate(int d) {
		for (int r = 0; r < d/45; r++) {
			int[] temp = new int[n];
			for (int i = 0; i < n/2; i++) {
				temp[i] = arr[i][i];
				
				arr[i][i] = arr[n/2][i];
				arr[n/2][i] = arr[n-1-i][i];
				arr[n-1-i][i] = arr[n-1-i][n/2];
				arr[n-1-i][n/2] = arr[n-1-i][n-1-i];
				arr[n-1-i][n-1-i] = arr[n/2][n-1-i];
				arr[n/2][n-1-i] = arr[i][n-1-i];
				arr[i][n-1-i] = arr[i][n/2];
				arr[i][n/2] = temp[i];
			}
		}
	}
	
	private static void reverseRotate(int d) {
		for (int r = 0; r < d/45; r++) {
			int[] temp = new int[n];
			for (int i = 0; i < n/2; i++) {
				temp[i] = arr[i][i];

				arr[i][i] = arr[i][n/2];
				arr[i][n/2] = arr[i][n-1-i];
				arr[i][n-1-i] = arr[n/2][n-1-i];
				arr[n/2][n-1-i] = arr[n-1-i][n-1-i];
				arr[n-1-i][n-1-i] = arr[n-1-i][n/2];
				arr[n-1-i][n/2] = arr[n-1-i][i];
				arr[n-1-i][i] = arr[n/2][i];
				arr[n/2][i] = temp[i];
			}
		}
	}

}
