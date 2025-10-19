package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1347 {
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];//0 : 벽, 1 : 길
		
		int maxX = -1;
		int maxY = -1;
		int minX = 102;
		int minY = 102;
		
		int x = 50;
		int y = 50;
		maxX = Math.max(maxX, x);
		maxY = Math.max(maxY, y);
		minX = Math.min(minX, x);
		minY = Math.min(minY, y);
		
		map[x][y] = 1;
		int dir = 2;
		String[] command = br.readLine().split("");
		for (int i = 0; i < n; i++) {
			if (command[i].equals("L")) {
				dir = (dir + 3) % 4;
			} else if (command[i].equals("R")) {
				dir = (dir + 1) % 4;
			} else {//F일 때
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				map[nx][ny] = 1;
				
				maxX = Math.max(maxX, nx);
				maxY = Math.max(maxY, ny);
				minX = Math.min(minX, nx);
				minY = Math.min(minY, ny);
				
				x = nx;
				y = ny;
			}
		}
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if(map[i][j] == 1) {
					System.out.print(".");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}

}
