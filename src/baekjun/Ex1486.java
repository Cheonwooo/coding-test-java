package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1486 {
	
	private static class Node implements Comparable<Node> {
		int time;
		int dist;
		int x;
		int y;

		public Node(int time, int dist, int x, int y) {
			this.time = time;
			this.dist = dist;
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Node other) {
			if (this.time == other.time) {
				return other.dist - this.dist;
			}
			return this.time - other.dist;
		}
	}
	
	private static int n, m, t, d;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map, distMap;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (Character.isUpperCase(input[j])) {
					map[i][j] = input[j] - 'A';
				} else {
					map[i][j] = input[j] - 'A' - 6;
				}
			}
		}
		
		distMap = new int[n][m];
//		for (int i = 0; i < n; i++) {
//			Arrays.fill(distMap[i], 10_000_001);
//		}
//		distMap[0][0] = 0;
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int answer = 0;
		upBfs(0, 0);
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(distMap[i][j] + " ");
//			}
//			System.out.println();
//		}
		downBfs(0, 0);
//		for (int i = n-1; i >= 0; i--) {
//			for (int j = m-1; j >= 0; j--) {
//				if (distMap[i][j] != 10_000_001) {
//					if (downBfs(i, j)) {
////						System.out.println(map[i][j]);
//						answer = Math.max(answer, map[i][j]);
//					}
//				}
//			}
//		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (distMap[i][j] <= d) {
					answer = Math.max(answer, map[i][j]);
				}
			}
		}
		System.out.println(answer);
	}
	
	private static void upBfs(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0, 0));
		
		int[][] tempMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(tempMap[i], 10_000_001);
		}
		tempMap[0][0] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int time = cur.time;
			int dist = cur.dist;
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				
				int disHeight = Math.abs(map[nx][ny] - map[cx][cy]);
				if (disHeight > t) continue;
				
				if (map[nx][ny] > map[cx][cy]) {
					int takeTime = (int)Math.pow(disHeight, 2) + time;
					if (takeTime > d) continue;
					
					if (tempMap[nx][ny] > takeTime) {
						tempMap[nx][ny] = takeTime;
						pq.offer(new Node(takeTime, disHeight, nx, ny));
					}
				} else {
					int takeTime = time + 1;
					if (takeTime > d) continue;
					
					if (tempMap[nx][ny] > takeTime) {
						tempMap[nx][ny] = takeTime;
						pq.offer(new Node(takeTime, Math.abs(disHeight), nx, ny));
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				distMap[i][j] += tempMap[i][j];
			}
		}
	}
	
	private static void downBfs(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0, 0));
		
		int[][] tempMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(tempMap[i], 10_000_001);
		}
		tempMap[0][0] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int time = cur.time;
			int dist = cur.dist;
			int cx = cur.x;
			int cy = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				
				int disHeight = map[cx][cy] - map[nx][ny];
				if (Math.abs(disHeight) > t) continue;
				
				if (map[nx][ny] < map[cx][cy]) {
					int takeTime = (int)Math.pow(disHeight, 2) + time;
					if (takeTime > d) continue;
					
					if (tempMap[nx][ny] > takeTime) {
						tempMap[nx][ny] = takeTime;
						pq.offer(new Node(takeTime, disHeight, nx, ny));
					}
				} else {
					int takeTime = time + 1;
					if (takeTime > d) continue;
					
					if (tempMap[nx][ny] > takeTime) {
						tempMap[nx][ny] = takeTime;
						pq.offer(new Node(takeTime, Math.abs(disHeight), nx, ny));
					}
				}
//				if (tempMap[nx][ny] > time) {
//					int takeTime = (int)Math.pow(disHeight, 2) + time;
//					if (disHeight <= 0) takeTime = time + 1;
//					if (takeTime > d) continue;
//					
//					tempMap[nx][ny] = takeTime;
//					pq.offer(new Node(takeTime, disHeight, nx, ny));
//				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				distMap[i][j] += tempMap[i][j];
			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				if (distMap[i][j] > 10_000_000) {
//					System.out.print(0 + " ");
//				} else {
//					System.out.print(distMap[i][j] + " ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
}
