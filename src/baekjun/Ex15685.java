package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex15685 {
	private static int[] dx = {0, -1, 0, 1};
	private static int[] dy = {1, 0, -1, 0};
	private static boolean[][] visited = new boolean[101][101];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			visited[x][y] = true;
			dragonCurve(x, y, d, g);
		}
		
		int answer = checkPartOfDragonCurve();
		System.out.println(answer);
	}
	
	public static void dragonCurve(int startX, int startY, int d, int g) {
		List<Integer> directions = new ArrayList<>();
		
		directions.add(d);
		int nx = startX + dx[d];
		int ny = startY + dy[d];
		visited[nx][ny] = true;
		int count = 1;
		
		while (count != Math.pow(2, g)) {
			int size = directions.size();
			
			for (int i = size-1; i >= 0; i--) {
				int newD = (directions.get(i) + 1) % 4;
				directions.add(newD);
				int cx = nx + dx[newD];
				int cy = ny + dy[newD];
				visited[cx][cy] = true;
				count++;
				
				nx = cx;
				ny = cy;
			}
		}
	}

	public static int checkPartOfDragonCurve() {
		int count = 0;
		for (int i = 0 ; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (visited[i][j] &&
						visited[i][j+1] &&
						visited[i+1][j] &&
						visited[i+1][j+1]) count++;
			}
		}
		return count;
	}
}
