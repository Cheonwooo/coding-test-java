package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex16955 {
		
	private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[10][10];
		for (int i = 0; i < 10; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'X';
					if (checkWin()) {
						System.out.println(1);
						return;
					}
					map[i][j] = '.';
				}
			}
		}
		System.out.println(0);
	}
	
	private static boolean checkWin() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 'X') {
					for (int k = 0; k < 8; k++) {
						int cx = i;
						int cy = j;
						int count = 1;
						while (true) {
							int nx = cx + dx[k];
							int ny = cy + dy[k];
							
							if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) break;
							if (map[nx][ny] == 'X') {
								count++;
								cx = nx;
								cy = ny;
							} else {
								break;
							}
							
							if (count == 5) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
		
		
	}
}
