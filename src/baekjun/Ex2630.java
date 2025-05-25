package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2630 {
	
	private static int white, blue;
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		div(0, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	private static void div(int x, int y, int len) {
		if (checkColor(x, y, len)) {
			if (map[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		
		int newLen = len / 2;
		
		div(x, y, newLen);
		div(x, y + newLen, newLen);
		div(x + newLen, y, newLen);
		div(x + newLen, y + newLen, newLen);
	}
	
	private static boolean checkColor(int x, int y, int len) {
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (map[i][j] != map[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
}
