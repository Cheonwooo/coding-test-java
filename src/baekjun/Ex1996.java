package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1996 {
	
	private static int n;
	private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static int[][] answer;
	private static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		answer = new int[n][n];
		
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0 ; i< n ;i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != '.') {
					answer[i][j] = -1;
					
					int cx = i;
					int cy = j;
					
					for (int k = 0; k < 8; k++) {
						int nx = cx + dx[k];
						int ny = cy + dy[k];
						
						if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] == -1) continue;
						answer[nx][ny] += map[i][j]-'0';
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i< n ;i++) {
			for (int j = 0; j < n; j++) {
				if (answer[i][j] == -1) {
					sb.append("*");
				} else if (answer[i][j] >= 10) {
					sb.append("M");
				} else {
					sb.append(answer[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
