package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16236 {
	public static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int distance;
		
		public Fish(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
		public int compareTo(Fish other) {
			if (this.distance == other.distance) {
				if (this.x == other.x) {
					return this.y - other.y;
				}
				return this.x - other.x;
			}
			return this.distance - other.distance;
		}
	}
	
	private static int n, answer, eatCount, sharkX, sharkY, sharkSize = 2;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
				}
			}
		}
		
		answer = 0;
		eatCount = 0;
		while (true) {
			PriorityQueue<Fish> fishes = new PriorityQueue<>();
			checkFishSize(fishes);
			
			if (fishes.isEmpty()) break;
			eatFish(fishes);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("sharkSize = " + sharkSize);
		}
		System.out.println(answer);
	}
	
	public static void checkFishSize(PriorityQueue<Fish> fishes) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0 && map[i][j] < sharkSize) {
					int distance = calculateDistance(i, j);
					
					if (distance != 0) {
						fishes.offer(new Fish(i, j, distance));
					}
				}
			}
		}
	}
	
	public static int calculateDistance(int x, int y) {
		int[][] tempMap = new int[n][n];
		visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		
		visited[sharkX][sharkY] = true;
		q.offer(new int[] {sharkX, sharkY});
		
		while (!q.isEmpty()) {
			int[] pair = q.poll();
			int cx = pair[0];
			int cy = pair[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				if (map[nx][ny] <= sharkSize) {
					tempMap[nx][ny] = tempMap[cx][cy] + 1;
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return tempMap[x][y];
	}
	
	public static void eatFish(PriorityQueue<Fish> fishes) {
		map[sharkX][sharkY] = 0;
		
		Fish fish = fishes.poll();
		sharkX = fish.x;
		sharkY = fish.y;
		map[sharkX][sharkY] = 9;
		
		eatCount++;
		answer += fish.distance;
		if (eatCount == sharkSize) {
			sharkSize++;
			eatCount = 0;
		}
	}
}
