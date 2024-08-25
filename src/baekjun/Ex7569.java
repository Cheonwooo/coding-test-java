package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex7569 {
	public static class Point implements Comparable<Point>{
		int h;
		int x;
		int y;
		int day;

		public Point(int h, int x, int y, int day) {
			this.h = h;
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
		public int compareTo(Point o) {
			return this.day - o.day;
		}

		@Override
		public String toString() {
			return "Point [h=" + h + ", x=" + x + ", y=" + y + ", day=" + day + "]";
		}
		
		
	}
	
	private static int n, m, h, tomatoCount, answer;
	private static int[] dx = {-1, 0, 1, 0, 0, 0};//북동남서상하
	private static int[] dy = {0, 1, 0, -1, 0, 0};
	private static int[] dh = {0, 0, 0, 0, 1, -1};
	private static int[][][] arr;
	private static boolean[][][] visited;
	private static PriorityQueue<Point> tomato = new PriorityQueue<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][n][m];
		visited = new boolean[h][n][m];
		
		tomatoCount = 0;
		answer = 0;
		for (int i= 0; i < h; i++ ) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 0) {
						tomatoCount++;
					} else if(arr[i][j][k] == 1) {
						tomato.add(new Point(i, j, k, 0));
					}
				}
			}
		}
		
		//bfs
		//다 돌고서 토마토 갯수가 남아있다면 -1, 다 사라졌다면 일 수 출력
		bfs();
		
		if (tomatoCount != 0) System.out.println(-1);
		else System.out.println(answer);
	}
	
	public static void bfs() {
		while (!tomato.isEmpty()) {
			Point p = tomato.poll();
			
			int cx = p.x;
			int cy = p.y;
			int ch = p.h;
			int day = p.day;

			if (tomatoCount == 0) {
				answer = day;
			}
			
			for (int i = 0; i < 6; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				int nh = ch + dh[i];
				int nday = day;
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || nh < 0 || nh >= h 
						|| visited[nh][nx][ny] || arr[nh][nx][ny] == -1 || arr[nh][nx][ny] == 1) continue; 
				
				visited[nh][nx][ny] = true;
				arr[nh][nx][ny] = 1;
				tomatoCount--;
				tomato.add(new Point(nh, nx, ny, nday+1));
			}
		}
	}
}
