package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17143 {
	public static class Shark {
		int x;
		int y;
		int speed;
		int dis;
		int size;

		public Shark(int speed, int dis, int size) {
			this.speed = speed;
			this.dis = dis;
			this.size = size;
		}

	}

	private static int R, C, answer;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static Shark[][] shark, tempShark;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		shark = new Shark[R + 1][C + 1];

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			shark[r][c] = new Shark(s, d, z);
		}


		answer = 0;
		for (int fisher = 1; fisher <= C; fisher++) {
			catchFish(fisher);
			tempShark = new Shark[R + 1][C + 1];
			move();
			copy();
		}
		System.out.println(answer);
	}

	public static void catchFish(int fisher) {
		for (int i = 1; i <= R; i++) {
			if (shark[i][fisher] != null) {
				answer += shark[i][fisher].size;
				shark[i][fisher] = null;
				break;
			}
		}
	}

	public static void move() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (shark[i][j] != null) {
					moveShark(i, j);
				}
			}
		}
	}

	public static void moveShark(int x, int y) {
		Shark s = shark[x][y];
		int cx = x;
		int cy = y;
		int speed = 0;
		int dis = s.dis;
		int size = s.size;

		if (dis == 0 || dis == 1) {
			speed = s.speed % ((R-1)*2);
		} else {
			speed = s.speed % ((C-1)*2);
		}
		
		for (int i = 0; i < speed; i++) {
			int nx = cx + dx[dis];
			int ny = cy + dy[dis];

			if (nx < 1 || nx > R || ny < 1 || ny > C) {
				nx = cx - dx[dis];
				ny = cy - dy[dis];

				if (dis == 0 || dis == 1) {
					dis = (dis + 1) % 2;
				} else if (dis == 2) {
					dis = 3;
				} else {
					dis = 2;
				}
			}
			cx = nx;
			cy = ny;
		}

		Shark newShark = new Shark(speed, dis, size);
		if (tempShark[cx][cy] == null) {
			tempShark[cx][cy] = newShark;
		}
		if (tempShark[cx][cy] != null & tempShark[cx][cy].size < newShark.size) {
			tempShark[cx][cy] = newShark;
		}
	}

	public static void copy() {
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= C; j++) {
				shark[i][j] = tempShark[i][j];
			}
		}
	}
}