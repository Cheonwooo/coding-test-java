package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11315 {
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int N = Integer.parseInt(br.readLine());
			String[][] map = new String[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = str[j];
				}
			}
			boolean check = false;
			outerLoop:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("o")) {
						for (int k = 0; k < 8; k++) {
							if (isFiveInRow(map, N, i, j, dx[k], dy[k])) {
								sb.append("YES").append("\n");
								check = true;
								break outerLoop;	
							}
						}
					}
				}
			}
			if(!check) {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static boolean isFiveInRow(String[][] map, int N, int x, int y, int dirX, int dirY) {
		int count = 1;
		for (int l = 1; l < 5; l++) {
			int nx = x + l * dirX;
			int ny = y + l * dirY;
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				return false;
			}
			
			if (!map[nx][ny].equals("o")) {
				return false;
			}
			count++;
		}
		return count == 5;
	}

}
