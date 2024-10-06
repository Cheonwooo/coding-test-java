package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 14MB, 시간 163ms

public class 고대_문명_유적_탐사 {
	
	private static class Score implements Comparable<Score> {
		int x;
		int y;
		int value;
		int turnCnt;

		public Score(int x, int y, int value, int turnCnt) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.turnCnt = turnCnt;
		}
		
		public int compareTo(Score o) {
			if (this.value == o.value &&
					this.turnCnt == o.turnCnt &&
					this.y == o.y) {
				return this.x - o.x;
			}
			
			if (this.value == o.value &&
					this.turnCnt == o.turnCnt) {
				return this.y - o.y;
			}
			
			if (this.value == o.value) {
				return this.turnCnt - o.turnCnt;
			}
			return o.value - this.value;
		}

		@Override
		public String toString() {
			return "Score [x=" + x + ", y=" + y + ", value=" + value + ", turnCnt=" + turnCnt + "]";
		}
		
	}
	
	private static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point o) {
			if (this.y == o.y) {
				return o.x - this.x;
			}
			return this.y - o.y;
		}
	}
	
	private static int k, m, startIndex, realIndex, answer;
	private static int[] numbers;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map, tempMap;
	private static boolean isOut = false;
	private static boolean[][] visited;
	private static List<Point> list;
	private static PriorityQueue<Score> pq;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		init();
		startIndex = 0;
		realIndex = 0;
		for (int turn = 0; turn < k; turn++) {
			startIndex = realIndex;
			pq = new PriorityQueue<>();
			for (int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 3; j++) {
						startRotate(i, j, 0, false);
					
				}
			}
			Score score = pq.poll();
			
			startRotate(score.x, score.y, score.turnCnt, true);
			if (isOut) break;
			for (int i = 0; i < 5; i++) {
				System.arraycopy(tempMap[i], 0, map[i], 0, 5);
			}
		}
		System.out.println(sb);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[5][5];
		numbers = new int[m];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void startRotate(int x, int y, int t, boolean selectStartPoint) {
		tempMap = new int[5][5];
		for (int i = 0; i < 5; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, 5);
		}
		
		if (!selectStartPoint) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					System.arraycopy(map[j], 0, tempMap[j], 0, 5);
				}
				for (int j = 0; j <= i; j++) {
					rotate(x, y, tempMap);
				}
				int value = 0;
				value = selectTrip(tempMap);
				pq.add(new Score(x, y, value, i+1));
			}
		} else {
			for (int i = 0; i < t; i++) {
				rotate(x, y, tempMap);
			}
			int value = trip(tempMap);
			if (value == 0) {
				isOut = true;
				return;
			}
			sb.append(value + " "); 
		}
		
		
	}

	private static void rotate(int x, int y, int[][] tempMap) {
		int[][] oriMap = new int[3][3];
		int[][] copyMap = new int[3][3];
		
		for (int i = x-1, cx = 0; i < x+2; i++, cx++) {
			for (int j = y-1, cy = 0; j < y+2; j++, cy++) {
				oriMap[cx][cy] = tempMap[i][j]; 
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				copyMap[i][j] = oriMap[3-j-1][i];
			}
		}
		
		for (int i = x-1, cx = 0; i < x+2; i++, cx++) {
			for (int j = y-1, cy = 0; j < y+2; j++, cy++) {
				tempMap[i][j] = copyMap[cx][cy]; 
			}
		}
		
	}
	
	private static int selectTrip(int[][] tempMap) {
		int value = 0;
		startIndex = 0;
		visited = new boolean[5][5];
		list = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (visited[i][j])
					continue;
				bfs(tempMap, i, j);
			}
		}
		if (list.size() == 0) return 0;
		
		Collections.sort(list);
		for (Point p : list) {
			tempMap[p.x][p.y] = numbers[startIndex++];
			if (startIndex == numbers.length) startIndex = 0;
		}
		value += list.size();
		return value;
	}
	
	private static int trip(int[][] tempMap) {
		int value = 0;
		
		while(true) {
			visited = new boolean[5][5];
			list = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (visited[i][j]) continue;
					bfs(tempMap, i, j);
				}
			}

	
			if (list.size() == 0) break;
			Collections.sort(list);
			for (Point p : list) {
				tempMap[p.x][p.y] = numbers[realIndex++];
				if (realIndex == numbers.length) realIndex = 0;
			}
			value += list.size();
		}
		return value;
	}

	private static void bfs(int[][] tempMap, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		List<Point> checkPoint = new ArrayList<>();
		boolean[][] checkVisit = new boolean[5][5];
		checkVisit[x][y] = true;
		q.add(new int[] {x, y});
		checkPoint.add(new Point(x, y));
		
		int count = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
				if (checkVisit[nx][ny] || tempMap[nx][ny] != tempMap[cx][cy]) continue;
				
				count++;
				checkVisit[nx][ny] = true;
				checkPoint.add(new Point(nx, ny));
				q.add(new int[] {nx, ny});
			}
		}
		
		if (count >= 3) {
			for (Point cur : checkPoint) {
				visited[cur.x][cur.y] = true;
			}
			list.addAll(checkPoint);
		}
	
	}
}


