package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex29733 {
	
	private static int r, c, h;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static char[][][] map;
	private static int[][][] answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new char[h][r][c];
		answer = new int[h][r][c];
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				map[i][j] = br.readLine().toCharArray();
			}
		}
		
		for (int i = 0 ; i < h; i++) {
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (map[i][j][k] != '*') findMine(i, j, k);
				}
			}
		}
		
		for (int i = 0 ; i < h; i++) {
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (map[i][j][k] == '*') {
						sb.append("*");
					} else {
						sb.append(answer[i][j][k]);
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void findMine(int x, int y, int z) {
		//현재 층 확인
		findCurrentFloor(x, y, z);
		findUpFloor(x, y, z);
		findDownFloor(x, y, z);
	}
	
	private static void findCurrentFloor(int x, int y, int z) {
		for (int i = 0; i < 8; i++) {
			int ny = y + dx[i];
			int nz = z + dy[i];
			
			if (ny < 0 || ny >= r || nz < 0 || nz >= c) continue;
			if (map[x][ny][nz] == '*') {
				answer[x][y][z] = (answer[x][y][z] + 1) % 10;
			}
		}
	}
	
	private static void findUpFloor(int x, int y, int z) {
		int nx = x + 1;
		
		if (nx >= h) return;
		
		if (map[nx][y][z] == '*') {
			answer[x][y][z] = (answer[x][y][z] + 1) % 10;
		}
		
		for (int i = 0; i < 8; i++) {
			int ny = y + dx[i];
			int nz = z + dy[i];
			
			if (ny < 0 || ny >= r || nz < 0 || nz >= c) continue;
			if (map[nx][ny][nz] == '*') {
				answer[x][y][z] = (answer[x][y][z] + 1) % 10;
			}
		}
	}
	
	private static void findDownFloor(int x, int y, int z) {
		int nx = x - 1;
		
		if (nx < 0) return;
		
		if (map[nx][y][z] == '*') {
			answer[x][y][z] = (answer[x][y][z] + 1) % 10;
		}
		
		for (int i = 0; i < 8; i++) {
			int ny = y + dx[i];
			int nz = z + dy[i];
			
			if (ny < 0 || ny >= r || nz < 0 || nz >= c) continue;
			if (map[nx][ny][nz] == '*') {
				answer[x][y][z] = (answer[x][y][z] + 1) % 10;
			}
		}
	}
}
