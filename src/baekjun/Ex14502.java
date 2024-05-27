package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14502 {
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int n, m, max;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[] temp = new int[3];
	private static int[][] map, copyMap; 
	private static boolean[] visited;
	private static List<Point> zeroPoint = new ArrayList<>();
	private static List<Point> virus = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		copyMap = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 0) {
					zeroPoint.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}
		
		visited = new boolean[zeroPoint.size()];
		max = Integer.MIN_VALUE;
		dfs(0, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int start, int depth) {
		if (depth == 3) {
			for (int i = 0; i < n; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, m);
			}
			
			makeWall(temp);
			
			for (int i = 0; i < virus.size(); i++) {
				Point point = virus.get(i);
				bfs(point.x, point.y);
			}
			
			max = Math.max(max, calculateSafeZone());
			return;
		}
		
		for (int i = start; i < zeroPoint.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void makeWall(int[] temp) {
		for (int val : temp) {
			Point point = zeroPoint.get(val);
			copyMap[point.x][point.y] = 1; 
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		
		while (!q.isEmpty()) {
			Point point = q.poll();
			
			int cx = point.x;
			int cy = point.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || copyMap[nx][ny] == 1) continue;
				
				if (copyMap[nx][ny] == 0) {
					copyMap[nx][ny] = 2;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
	
	public static int calculateSafeZone() {
		int sum = 0;
		for (int[] row : copyMap) {
			for (int cell : row) {
				if (cell == 0) {
					sum++;
				}
			}
		}
		return sum;
	}
}
