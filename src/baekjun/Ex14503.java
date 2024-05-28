package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14503 {
	private static int n, m, x, y, d, count;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 0;
		cleanRoom(x, y);
		System.out.println(count);
	}
	
	public static void cleanRoom(int x, int y) {
		while (true) {
			if (map[x][y] == 0) {
				map[x][y] = 2;
				count++;
			}
			
			if (isNoCleanRoomExist(x, y)) {
				d += 3;
				d %= 4;
				
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (map[nx][ny] == 0) {
					x = nx;
					y = ny;
				}
				
			} else {
				int reverseD = (d+2)%4;
				int nx = x + dx[reverseD];
				int ny = y + dy[reverseD];
				
				if (map[nx][ny] == 1) break;
				if (map[nx][ny] == 2) {
					x = nx;
					y = ny;
				}
			}
		}
	}
	
	public static boolean isNoCleanRoomExist(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (map[nx][ny] == 0) return true;
		}
		return false;
	}
}
