package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Ex19236_2 {
	public static class Fish {
		int x;
		int y;
		int number;
		int d;
		int alive;

		public Fish(int x, int y, int number, int d, int alive) {
			this.x = x;
			this.y = y;
			this.number = number;
			this.d = d;
			this.alive = alive;
		}
	}
	
	private static int max = Integer.MIN_VALUE;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[][] map;
	private static Fish[] fish;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fish = new Fish[17];
		map = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int fishNumber = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				
				fish[fishNumber] = new Fish(i, j, fishNumber, dir, 0);
				map[i][j] = fishNumber;
			}
		}
		
		int answer = map[0][0];
		int sharkX = 0;
		int sharkY = 0;
		int sharkD = fish[map[0][0]].d;
		fish[map[0][0]].alive = -1;
		map[0][0] = 17;//»ó¾î
		
		dfs(sharkX, sharkY, sharkD, answer);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int d, int answer) {
		max = Math.max(max, answer);
		
		int[][] tempMap = new int[4][4];
		for (int i = 0; i < 4; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
		}
		
		Fish[] tempFish = new Fish[17];
		for (int i = 1; i < 17; i++) {
			tempFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].number, fish[i].d, fish[i].alive);
		}
		
		moveFish();
		
		for (int i = 1; i <= 4; i++) {
			int nx = x + dx[d]*i;
			int ny = y + dy[d]*i;
			
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4
					&& map[nx][ny] != 0) {
				int eatFish = map[nx][ny];
				int nd =fish[map[nx][ny]].d;
				
				map[x][y] = 0;
				map[nx][ny] = 17;
				fish[eatFish].alive = -1;
				
				dfs(nx, ny, nd, answer + eatFish);
				
				fish[eatFish].alive = 0;
				map[x][y] = 17;
				map[nx][ny] = eatFish;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			System.arraycopy(tempMap[i], 0, map[i], 0, map.length);
		}
		
		for (int i = 1; i < 17; i++) {
			fish[i] = fish[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].number, tempFish[i].d, tempFish[i].alive);
		}
	}
	
	public static void moveFish() {
		for (int i = 1; i < 17; i++) {
			if (fish[i].alive == -1) continue;
//			printMap();
//			System.out.println();
			int cd = fish[i].d;
			for (int j = 0; j < 8; j++) {
				int nd = (cd + j) % 8;
				int nx = fish[i].x + dx[nd];
				int ny = fish[i].y + dy[nd];
				
				if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4
						&& map[nx][ny] != 17) {
					fish[i].d = nd;
					
					if (map[nx][ny] == 0) {
						map[fish[i].x][fish[i].y] = 0;
						
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					} else {
						int changeFish = map[nx][ny];
						
						fish[changeFish].x = fish[i].x;
						fish[changeFish].y = fish[i].y;
						map[fish[changeFish].x][fish[changeFish].y] = changeFish;

						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					}
					break;
				}
			}
		}
	}
	public static void printMap() {
		for (int i = 0; i < 4 ; i++) {
			for (int j = 0 ; j<4; j++) {
				if (map[i][j] == 17) {
					System.out.print(17 + "," + 0 + " ");
				} else {
					System.out.print(map[i][j] + "," + fish[map[i][j]].d + " ");
				}
			}
			System.out.println();
		}
	}
}
