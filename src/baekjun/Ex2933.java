package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//�޸� 78936kb, �ð� 396ms

public class Ex2933 {
	
	private static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		public int compareTo(Point o) {
			return o.x - this.x;
		}
	}
	
	private static int r, c, n;
	private static int[] heights, dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static char[][] minerals, copyMinerals;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		minerals = new char[r][c];
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				minerals[i][j] = input.charAt(j);
			}
		}
		
		n = Integer.parseInt(br.readLine());
		heights = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		//r - heights[i]���̿� ����
		breakMineral();
		for (int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(minerals[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void breakMineral() {
		for (int i = 1; i < n+1; i++) {
			
			boolean isBreak = false;
			int col = 0;
			if (i % 2 == 0) {//�������� ������
				for (int j = c-1; j >= 0; j--) {
					if (minerals[r - heights[i]][j] == 'x') {
						minerals[r - heights[i]][j] = '.';
						isBreak = true;
						col = j;
						break;
					}
				}
			} else {// ���������� ������
				for (int j = 0; j < c; j++) {
					if (minerals[r - heights[i]][j] == 'x') {
						minerals[r - heights[i]][j] = '.';
						isBreak = true;
						col = j;
						break;
					}
				}
			}
			
			if (isBreak) {//�̳׶��� �ν��ٸ� bfs ����
				copyMinerals = new char[r][c];
				for (int j = 0; j < r; j++) {
					for (int k = 0; k < c; k++) {
						copyMinerals[j][k] = minerals[j][k];
					}
				}
//				for (int j = 0; j < r; j++) {
//					System.arraycopy(minerals[j], 0, copyMinerals[j], 0, c);
//				}
				
				for (int j = 0; j < 4; j++) {
					int nx = (r - heights[i]) + dx[j];
					int ny = col + dy[j];
					
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || minerals[nx][ny] == '.') continue;
					if (minerals[nx][ny] == 'x') {
						if (move(nx, ny)) break;
					}
				}
				
//				for (int j = 0; j < r; j++) {
//					System.arraycopy(copyMinerals[j], 0, minerals[j], 0, c);
//				}
				for (int j = 0; j < r; j++) {
					for (int k = 0; k < c; k++) {
						minerals[j][k] = copyMinerals[j][k];
					}
				}
			}
		}
	}
	
	public static boolean  move(int x, int y) {
		boolean[][] visited = new boolean[r][c];
		List<Point> points = findMinerals(visited, x, y);
		
		//���̻� ������ �̳׶��� ���ٸ� �� ��
		if (points == null) return false;
		
		Collections.sort(points);
		while (true) {
			fallClusters(points, visited);
			if (!isCanFall(points, visited)) break;
		}
		return true;
	}
	
	public static List<Point> findMinerals(boolean[][] visited, int x, int y) {
		//�ٴ��̶�� ��
		if (x == r-1) return null;
		
		List<Point> points = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		
		points.add(new Point(x, y));
		visited[x][y] = true;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			int cx = now[0];
			int cy = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] || minerals[nx][ny] == '.') continue;
				//�ٴ��� ������ ��
				if (nx == r-1) return null;
				if (minerals[nx][ny] == 'x') {//�̳׶��� ��츸
					visited[nx][ny] = true;
					points.add(new Point(nx, ny));
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return points;
	}
	
	public static void fallClusters(List<Point> points, boolean[][] visited) {
		for (Point point : points) {
			copyMinerals[point.x][point.y] = '.';//���� �ڸ��� ����
			visited[point.x][point.y] = false; 
			copyMinerals[point.x+1][point.y] = 'x';//�� ĭ �Ʒ��� �̳׶��� ä���
			visited[point.x+1][point.y] = true;
			point.x += 1;
		}
	}
	
	public static boolean isCanFall(List<Point> points, boolean[][] visited) {
		for (Point point : points) {
			//�̹� �ٴ��̶�� ���̻� ������ �� ����
			if ((point.x) == r-1) return false;
			//�� ĭ �Ʒ��� �湮���� ����(���� �׷��� �ƴ�) x��� �� �̻� ������ �� ����
			if (!visited[point.x+1][point.y] && copyMinerals[point.x+1][point.y] == 'x') {
				return false;
			}
		}
		//������ �� ����
		return true;
	}
}

//6 5
//.....
//..x..
//..xxx
//..x.x
//..x..
//..x..
//3
//4 1 1

//8 8
//xxxxx...
//...xxx..
//x.xxx...
//xxx.....
//..xx...x
//..x....x
//..xxxxxx
//.....x..
//3
//1 4 6


