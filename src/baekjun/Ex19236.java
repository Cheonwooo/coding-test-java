package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19236 {

	private static class Fish {
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
	private static int[][] fishMap;
	private static Fish[] fishes;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		fishes = new Fish[17];
		fishMap = new int[4][4];
		//0 : ºóÄ­
		//17 : »ó¾î°¡ ÀÖ´ÂÄ­ 
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				int fishNumber = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken()) - 1;
				
				fishes[fishNumber] = new Fish(i, j, fishNumber, direction, 1);
				fishMap[i][j] = fishNumber;
			}
		}
		
		int answer = fishMap[0][0];
		int sharkX = 0;
		int sharkY = 0;
		int sharkD = fishes[fishMap[0][0]].d;
		fishes[fishMap[0][0]].alive = 0;
		fishMap[0][0] = 17;
		
		dfs(sharkX, sharkY, sharkD, answer);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int d, int answer) {
		max = Math.max(max, answer);
		
		int[][] tempFishMap = new int[4][4];
		for (int i = 0; i < fishMap.length; i++) {
			System.arraycopy(fishMap[i], 0, tempFishMap[i], 0, fishMap.length);
		}
		
		Fish[] tempFish = new Fish[17];
		for (int i = 1; i < 17; i++) {
			tempFish[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].number, fishes[i].d, fishes[i].alive);
		}
		
		moveFish();
		
		for(int i=1; i<4; i++) {
			int nx = x + dx[d]*i;
			int ny = y + dy[d]*i;
			
			if(nx>=0 && nx<4 && ny>=0 && ny<4 && fishMap[nx][ny]!=0) {
				int eatFish = fishMap[nx][ny];
				int nd = fishes[eatFish].d;
				
				fishMap[x][y] = 0;
				fishMap[nx][ny] = 17;
				fishes[eatFish].alive = 0;
				
				dfs(nx, ny, nd, answer+eatFish);
				
				fishes[eatFish].alive = 1;
				fishMap[x][y] = 17;
				fishMap[nx][ny] = eatFish;
				
			}
		}
		
		for (int i = 0; i < fishMap.length; i++) {
			System.arraycopy(tempFishMap[i], 0, fishMap[i], 0, fishMap.length);
		}
		
		for (int i = 1; i < 17; i++) {
			fishes[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].number, tempFish[i].d, tempFish[i].alive);
		}
		
	}
	
	public static void moveFish() {
		for(int i=1; i<17; i++) {
			if(fishes[i].alive==0) {
				continue;//Á×Àº ¹°°í±â¶ó¸é ÆÐ½º
			}
			
			int cnt = 0;
			int dir = fishes[i].d;
			int nx = 0, ny = 0;
			
			while(cnt<8) {
				
				dir%=8;
				
				fishes[i].d = dir;
				
				nx = fishes[i].x + dx[dir];
				ny = fishes[i].y + dy[dir];
				
				if(nx>=0 && nx<4 && ny>=0 && ny<4 && fishMap[nx][ny] != 17) {
					if(fishMap[nx][ny]==0) {
						fishMap[fishes[i].x][fishes[i].y] = 0;
						
						fishes[i].x = nx;
						fishes[i].y = ny;
						fishMap[nx][ny] = i;
					} else {
						int changeFish = fishMap[nx][ny];
						
						fishes[changeFish].x = fishes[i].x;
						fishes[changeFish].y = fishes[i].y;
						fishMap[fishes[changeFish].x][fishes[changeFish].y]= changeFish;
						 
						fishes[i].x = nx;
						fishes[i].y = ny;
						fishMap[nx][ny] = i;
						
					}
					break;
				} else {
					dir++;
					cnt++;
				}
			}
		}
	}
	
	
	public static void printMap(Fish[] fishes, int[][] fishMap) {
		for (int i = 0; i < 4 ; i++) {
			for (int j = 0 ; j<4; j++) {
				if (fishMap[i][j] == 17) {
					System.out.print(17 + "," + 0 + " ");
				} else {
					System.out.print(fishMap[i][j] + "," + fishes[fishMap[i][j]].d + " ");
				}
			}
			System.out.println();
		}
	}
}
