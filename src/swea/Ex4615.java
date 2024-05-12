package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex4615 {
	private static int N;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			map[N/2][N/2] = 2;
			map[N/2+1][N/2+1] = 2;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2] = 1;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				
				map[x][y] = color;
				play(x, y, color);
				
				for (int k = 1; k <= N; k++) {
					for (int j = 1; j <= N; j++) {
						System.out.print(map[k][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			
			int black = 0;
			int white = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1) black++;
					else if (map[i][j] == 2) white++;
				}
			}
			
			
			sb.append(black + " " + white).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void play(int x, int y, int color) {
		for (int i = 0; i < 8; i++) {
			if (checkSameColor(i, x, y, color)) {
				changeColor(i, x, y, color);
			}
		}
	}

	public static boolean checkSameColor(int d, int x, int y, int color) {
		int cx = x;
		int cy = y;
		boolean check = false;
		
		while (true) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			if (nx < 1 || nx > N || ny < 1|| ny >N) {
				break;
			}
			
			if (map[nx][ny] == 0) {
				break;
			}
			
			if (map[nx][ny] == color) {
				check = true;
				break;
			}
			
			
			cx = nx;
			cy = ny;
		}
		return check;
	}
	
	public static void changeColor(int d, int x, int y, int color) {
		int cx = x;
		int cy = y;
		
		while (true) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			if (map[nx][ny] == color) {
				break;
			}
			
			map[nx][ny] = color;
			cx = nx;
			cy = ny;
		}
	}
}
