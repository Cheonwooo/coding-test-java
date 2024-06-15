package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex15683_2 {
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n, m, min = Integer.MAX_VALUE;
	private static int[] temp;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new Point(i, j));
				}
			}
		}
		
		temp = new int[list.size()];
		dfs(0);
		System.out.println(min);
	}
	
	public static void dfs(int depth) {
		if (depth == list.size()) {
			int[][] copyMap = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			min = Math.min(min, calculateNotCctv(temp, copyMap));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			temp[depth] = i;
			dfs(depth+1);
		}
	}
	
	public static int calculateNotCctv(int[] temp, int[][] copyMap) {
		for (int i = 0; i < list.size(); i++) {
			changeCopyMap(list.get(i), copyMap, temp[i]);
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(copyMap[i][j] == 0) count++;
			}
		}
		return count;
	}
	
	public static void changeCopyMap(Point point, int[][] copyMap, int dir) {
		int cx = point.x;
		int cy = point.y;
		int cctvNumber = copyMap[cx][cy];

		if (cctvNumber == 1) {
			while (true) {
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || copyMap[nx][ny] == 6) break;
				
				cx = nx;
				cy = ny;
				
				if (copyMap[nx][ny] != 0 && copyMap[nx][ny] != 6) continue;
				
				copyMap[nx][ny] = 9;
			}
		} else if (cctvNumber == 2) {
			for (int i = dir%2; i < 4; i += 2) {
				cx = point.x;
				cy = point.y;

				while (true) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || copyMap[nx][ny] == 6) break;

					cx = nx;
					cy = ny;
					
					if (copyMap[nx][ny] != 0 && copyMap[nx][ny] != 6) continue;
					
					copyMap[nx][ny] = 9;
				}
			}
		} else if (cctvNumber == 3) {
			for (int i = dir; i < dir+2; i++) {
				cx = point.x;
				cy = point.y;
				int newDir = i%4;
				while (true) {
					int nx = cx + dx[newDir];
					int ny = cy + dy[newDir];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m || copyMap[nx][ny] == 6) break;
					
					cx = nx;
					cy = ny;
					
					if (copyMap[nx][ny] != 0 && copyMap[nx][ny] != 6) continue;
					
					copyMap[nx][ny] = 9;
				}
			}
		} else if (cctvNumber == 4) {
			for (int i = 0; i < 4; i++) {
				cx = point.x;
				cy = point.y;
				if (i == dir) continue;
				while (true) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || copyMap[nx][ny] == 6) break;
					
					cx = nx;
					cy = ny;
					
					if (copyMap[nx][ny] != 0 && copyMap[nx][ny] != 6) continue;
					
					copyMap[nx][ny] = 9;
				}
			}
		} else if (cctvNumber == 5) {
			for (int i = 0; i < 4; i++) {
				cx = point.x;
				cy = point.y;
				while (true) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m || copyMap[nx][ny] == 6) break;
					
					cx = nx;
					cy = ny;
					
					if (copyMap[nx][ny] != 0 && copyMap[nx][ny] != 6) {continue;
					
					}
					copyMap[nx][ny] = 9;
				}
			}
		}
	}

}
