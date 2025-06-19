package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex2448 {
	
	private static char[][] stars;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		stars = new char[n][n * 2 - 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(stars[i], ' ');
		}
		
		makeStars(0, n-1, n);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n * 2 - 1; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void makeStars(int r, int c, int n) {
		if (n == 3) {
			stars[r][c] = '*';
			stars[r + 1][c - 1] = '*';
			stars[r + 1][c + 1] = '*';
			stars[r + 2][c - 2] = '*';
			stars[r + 2][c - 1] = '*';
			stars[r + 2][c] = '*';
			stars[r + 2][c + 1] = '*';
			stars[r + 2][c + 2] = '*';
		} else {
			int len = n / 2;
			makeStars(r, c, len);
			makeStars(r + len, c - len, len);
			makeStars(r + len, c + len, len);
		}
	}
}
