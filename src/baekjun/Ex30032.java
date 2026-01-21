package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex30032 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		char[][] arr = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		if (d == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 'd') {
						arr[i][j] = 'q';
					} else if (arr[i][j] == 'b') {
						arr[i][j] = 'p';
					} else if (arr[i][j] == 'q') {
						arr[i][j] = 'd';
					} else {
						arr[i][j] = 'b';
					}
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 'd') {
						arr[i][j] = 'b';
					} else if (arr[i][j] == 'b') {
						arr[i][j] = 'd';
					} else if (arr[i][j] == 'q') {
						arr[i][j] = 'p';
					} else {
						arr[i][j] = 'q';
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
