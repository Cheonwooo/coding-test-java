package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16927 {
	
	private static int n, m, r;
	private static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int startX = 0;
		int startY = 0;
		while (startX < n/2 && startY < m/2) {
			int count = (n - (startX * 2)) * 2 + (m - (startY * 2)) * 2 - 4;
			int rCount  = r % count;
			rotate(startX, startY, rCount);
			startX += 1;
			startY += 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void rotate(int x, int y, int r) {
		for (int t = 0; t < r; t++) {
			int temp = arr[x][y];
			for (int i = y + 1; i <= m - 1 - y; i++) {
				arr[x][i-1] = arr[x][i];
			}
			for (int i = x + 1; i <= n - 1 - x; i++) {
				arr[i-1][m-1-y] = arr[i][m-1-y];
			}
			for (int i = m - y - 2; i >= y; i--) {
				arr[n-1-x][i+1] = arr[n-1-x][i];
			}
			for (int i = n - x - 2; i > x; i--) {
				arr[i+1][y] = arr[i][y];
			}
			arr[x+1][y] = temp;
			
		}
	}

}
