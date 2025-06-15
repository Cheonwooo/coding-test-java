package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex31924 {
	
	private static int n, answer;
	private static final String MOBIS = "MOBIS";
	private static String[][] map;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new String[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = input[j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].equals("M")) bfs(i, j);
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			String word = map[x][y];
			int cx = x;
			int cy = y;
			for (int j = 0; j < 4; j++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				word += map[nx][ny];
				cx = nx;
				cy = ny;
			}
			
			if (word.equals(MOBIS)) {
				answer++;
			}
		}
	}
}
