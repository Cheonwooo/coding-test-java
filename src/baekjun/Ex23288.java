package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 35960kb, 시간 180ms

public class Ex23288 {
	
	private static int n, m, dir, startX, startY, answer;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] dice, map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		makeDice();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		startX = 0;
		startY = 0;
		dir = 1;
		for (int i = 0; i < k ; i++) {
			moveDice();
		}
		
		System.out.println(answer);
	}
	
	public static void makeDice() {
		dice = new int[4][3];
		
		dice[0][1] = 2;
		dice[1][0] = 4;
		dice[1][1] = 1;
		dice[1][2] = 3;
		dice[2][1] = 5;
		dice[3][1] = 6;
	}
	
	public static void moveDice() {
		checkOutOfBound();
		rollDice();
		
		startX += dx[dir];
		startY += dy[dir];
		
		bfs();
		changeDirection();
	}
	
	public static void checkOutOfBound() {
		int nx = startX + dx[dir];
		int ny = startY + dy[dir];
		
		if (isOutOfBound(nx, ny)) {
			dir = (dir + 2) % 4;
		}
	}
	
	public static boolean isOutOfBound(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= m;
	}
	
	public static void rollDice() {
		if (dir == 0) {
			int temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
		} else if (dir == 1) {
			int temp = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = temp;
		} else if (dir == 2) {
			int temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
		} else if (dir == 3) {
			int temp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = temp;
		}
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		q.offer(new int[] {startX, startY});
		visited[startX][startY] = true;
		answer += map[startX][startY];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (isOutOfBound(nx, ny) || visited[nx][ny]) continue;
				if (map[nx][ny] != map[startX][startY]) continue;
				answer += map[nx][ny];
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	public static void changeDirection() {
		if (dice[3][1] > map[startX][startY]) {
			dir = (dir + 1) % 4;
		} else if (dice[3][1] < map[startX][startY]) {
			dir = (dir + 3) % 4;
		}
	}
}
