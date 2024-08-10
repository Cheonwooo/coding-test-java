package swBtype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SS_2024_2_1 {
	
	public static class Golam {
		int x;
		int y;
		int number;
		
		public Golam(int x, int y, int number) {
			this.x = x;
			this.y = y;
			this.number = number;
		}
	}

	private static int R, C, x, y, d, max, answer = 0;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int[][] map, tempMap;
	private static boolean[][] visited, tempVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[R+3][C];
		visited = new boolean[R+3][C];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			y = Integer.parseInt(st.nextToken()) - 1;
			d = Integer.parseInt(st.nextToken());

			boolean left = false;
			boolean right = false;
			x = 1;

			tempMap = new int[R+3][C];
			copyMap(tempMap, map);
			
			move(i + 1, left, right);
			copyMap(map, tempMap);
			if (checkResetMapAfterMoving()) {
				resetMap();
			}
			tempVisited = new boolean[R+3][C];
			if (d != -1) {
				checkExit();
				//점수 확인하기
//				calculateScore(i+1);
				answer += max;
			}
			
			printMap();
			System.out.println();
		}
		System.out.println(answer);
	}

	public static void move(int number, boolean left, boolean right) {
		if (checkResetMapWhileMoving()) {
			resetMap();
			return;
		}
		// d는 출구의 위치, 움직이는 방향이 아님
		if (left) {
			left = false;
			d = (d + 3) % 4;
		}
		if (right) {
			right = false;
			d = (d + 1) % 4;
		}

		for (int i = 1; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			int nx = cx + dx[2];
			int ny = cy + dy[2];

			// 바닥을 만난경우
			if (nx >= R+3)
				return;
			if (map[nx][ny] != 0) {// 골렘이랑 만난 경우 좌방향 체크
				for (int j = 0; j < 4; j++) {
					if (j == 1) continue;
					cx = x + dx[j];
					cy = y + dy[j];

					nx = cx + dx[3];
					ny = cy + dy[3];

//					 if (ny < 0) return;
					if (ny < 0 || map[nx][ny] != 0) {
						left = false;//좌방향으로 갈 수 없음
						break;
					}
					left = true;
				}
				if (left) {// 좌방향으로 갈 수 있다면
					y -= 1;
					if (canMoveDown()) {
						y += 1;
						tempMap[x][y] = 0;
						
						for (int j = 0; j < 4; j++) {
							cx = x + dx[j];
							cy = y + dy[j];

							tempMap[cx][cy] = 0;
						}
						y -= 1;
						move(number, left, right);
						return;
					} else {
						y += 1;
						for (int j = 0; j < 4; j++) {
							cx = x + dx[j];
							cy = y + dy[j];

							tempMap[cx][cy] = number; 
						}
						tempMap[x][y] = number;
						return;
					}
				} else {// 좌방향으로 갈 수 없는 경우 우방향 체크
					for (int j = 0; j < 3; j++) {
						cx = x + dx[j];
						cy = y + dy[j];

						nx = cx + dx[1];
						ny = cy + dy[1];

						if (ny >= C)
							return;
						if (map[nx][ny] != 0) {
							right = false;
							break;
						}
						right = true;
					}
					if (right) {// 우방향으로 갈 수 있다면
						y += 1;
						if (canMoveDown()) {//우 + 아래 가능하다면
							y -= 1;
							tempMap[x][y] = 0;
							for (int j = 0; j < 4; j++) {
								cx = x + dx[j];
								cy = y + dy[j];

								tempMap[cx][cy] = 0;
							}
							y += 1;
							move(number, left, right);
							return;	
						} else {//우 가능 아래 불가능인 경우 제자리에서만 체크
							y -= 1;
							for (int j = 0; j < 4; j++) {
								cx = x + dx[j];
								cy = y + dy[j];

								tempMap[cx][cy] = number; 
							}
							tempMap[x][y] = number;
							return;
						}
					}
					// 둘 다 갈 수 없다면
					if (!left && !right)
						return;
				}
			}
		}
		// 원래 칸 0으로 변경
		tempMap[x][y] = 0;
		for (int j = 0; j < 4; j++) {
			int cx = x + dx[j];
			int cy = y + dy[j];

			tempMap[cx][cy] = 0;
		}

		for (int j = 0; j < 4; j++) {
			int cx = x + dx[j];
			int cy = y + dy[j];

			int nx = cx + dx[2];
			int ny = cy + dy[2];
			tempMap[nx][ny] = number;
		}
		// 다음칸 해당 번호로 변경
		x += 1;
		tempMap[x][y] = number;
		
		move(number, left, right);
	}

	public static void printMap() {
		for (int i = 0; i < R+3; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < R+3; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j]) {
					System.out.print("X ");
				} else {
					System.out.print(map[i][j] + " ");
				}
				
			}
			System.out.println();
		}
	}
	
	public static void copyMap(int[][] map1, int[][] map2) {
		for (int i = 0; i < R + 3; i++) {
			for (int j = 0; j < C; j++) {
				map1[i][j] = map2[i][j];
			}
		}
	}
	
	public static boolean canMoveDown() {
		for (int j = 1; j < 4; j++) {
			int cx = x + dx[j];
			int cy = y + dy[j];
			
			int nx = cx + dx[2];
			int ny = cy + dy[2];
			
			if (map[nx][ny] != 0) return false;
		}
		return true;
	}
	
	public static boolean checkResetMapWhileMoving() {
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if (map[cx][cy] != 0) {
				d = -1;
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkResetMapAfterMoving() {
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			if (cx <= 2) {
				d = -1;
				return true;
			}
		}
		return false;
	}
	
	public static void resetMap() {
		for (int i = 0; i < R+3; i++) {
			Arrays.fill(map[i], 0);
			Arrays.fill(tempMap[i], 0);
			Arrays.fill(visited[i], false);
		}
	}
	
	public static void checkExit() {
		visited[x+dx[d]][y+dy[d]] = true;
	}
	
	public static void calculateScore(int number) {
		max = 0;
		bfs(number, x, y);
		System.out.println("============max : " + max);
	}
	
	public static void bfs(int number, int startX, int startY) {
		Queue<Golam> q = new LinkedList<>();
		q.add(new Golam(startX, startY, number));
		tempVisited[startX][startY] = true;
		
		while (!q.isEmpty()) {
			Golam g = q.poll();
			int cx = g.x;
			int cy = g.y;
			number = g.number;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				System.out.println("cx : " + cx + ", cy : " + cy + " " + nx + ", " + ny);
				
				if (nx >= R+3 || ny < 0 || ny >= C) continue;
				if (!tempVisited[nx][ny]) {
					if (map[nx][ny] == number) {
						max = Math.max(max, nx-2);
						q.add(new Golam(nx, ny, number));
						System.out.println("q in " + nx + " " + ny);
						tempVisited[nx][ny] = true;
					}
				}
				if (visited[cx][cy]) {
					System.out.println(cx + " " + cy);
					System.out.println(map[nx][ny]);
				}
				if (visited[cx][cy] && map[nx][ny] != 0 && map[nx][ny] != number) {
					max = Math.max(max, nx-2);
					q.add(new Golam(nx, ny, map[nx][ny]));
					tempVisited[nx][ny] = true;
				}
			}
		}
	}
}
/*
6 5 6
2 3
2 0
4 2
2 0
2 0
2 2

 */
