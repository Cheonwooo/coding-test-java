package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//�޸� 14356kb, �ð� 104ms

public class Ex19236_3 {
	
	private static class Fish{
		int x;
		int y;
		int d;
		boolean isAlive;

		public Fish(int x, int y, int d, boolean isAlive) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.isAlive = isAlive;
		}

		public Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
	
	private static int max = Integer.MIN_VALUE;
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static Fish shark;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] fishMap = new int[4][4];
		Fish[] fishes = new Fish[17];
		int answer = init(br, fishes, fishMap);
		dfs(fishes, fishMap, answer);
		System.out.println(max);
	}

	

	private static int init(BufferedReader br, Fish[] fishes, int[][] fishMap) throws IOException {
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int fishNum = Integer.parseInt(st.nextToken());
				int fishDir = Integer.parseInt(st.nextToken())-1;
				
				fishMap[i][j] = fishNum;
				fishes[fishNum] = new Fish(i, j, fishDir, true);
			}
		}
		
		int first = fishMap[0][0];
		int answer = first;
		//���� 0,0 ����⸦ �԰� ����
		shark = new Fish(0, 0, fishes[first].d);
		fishMap[0][0] = -1;
		fishes[first].isAlive = false;
		return answer;
	}
	
	private static void dfs(Fish[] fishes, int[][] fishMap, int answer) {
		// 1. ����� �̵�
		moveFish(fishes, fishMap);
		
		// 2. ��� �̵�
		// �� ������ �� �ִ� �ڸ� Ȯ���ϱ�
		List<int[]> next = moveSharkNext(fishMap);
		
		if (next.size() == 0) {//�� �� �̻� ������ �� ���ٸ� ��
			max = Math.max(max, answer);
			return;
		} else {//�� ������ �� �ִ� ��ġ�� �ִٸ�
			int sx = shark.x;
			int sy = shark.y;
			int sd = shark.d;
			
			for (int[] p : next) {//�� ������ �� �ִ� ��ǥ���� �� ����, dfs
				int[][] tempFishMap = new int[4][4];
				Fish[] tempFish = new Fish[17];
				
				//�� ����
				for (int i = 0; i < 4; i++) {
					System.arraycopy(fishMap[i], 0, tempFishMap[i], 0, 4);
				}
				//����� ����
				for (int i = 1; i < 17; i++) {
					tempFish[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].d, fishes[i].isAlive);
				}
				
				int nextX = p[0];
				int nextY = p[1];
				int nextFishNum = fishMap[nextX][nextY];
				
				//��� �̵�
				fishMap[sx][sy] = 0;
				fishMap[nextX][nextY] = -1;
				fishes[nextFishNum].isAlive = false;
				shark = new Fish(nextX, nextY, fishes[nextFishNum].d);
				
				dfs(fishes, fishMap, answer+nextFishNum);
				
				//��� ����ġ
				fishMap[sx][sy] = -1;
				fishMap[nextX][nextY] = nextFishNum;
				fishes[nextFishNum].isAlive = true;
				shark = new Fish(sx, sy, sd);
				
				//�� ����ġ
				for (int i = 0; i < 4; i++) {
					System.arraycopy(tempFishMap[i], 0, fishMap[i], 0, 4);
				}
				//����� ����
				for (int i = 1; i < 17; i++) {
					fishes[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].d, tempFish[i].isAlive);
				}
			}
		}
	}
	
	private static void moveFish(Fish[] fishes, int[][] fishMap) {
		for (int i = 1; i <= 16; i++) {
			//���� ������ �н�
			if (!fishes[i].isAlive) continue;
			
			//���� ���⿡ ����� �Ǵ� ��ĭ�� �ִٸ� �� �������� �̵�
			int curX = fishes[i].x;
			int curY = fishes[i].y;
			int nowDir = fishes[i].d;
			
			int nx = curX + dx[nowDir];
			int ny = curY + dy[nowDir];
			
			boolean canMove = true;
			if (!canFishMove(fishMap, nx, ny)) {//����Ⱑ ������ �� ���ٸ� 8���� Ž���ؼ� ã��
				for (int j = 0; j < 8; j++) {
					nx = curX + dx[(nowDir+j)%8];
					ny = curY + dy[(nowDir+j)%8];
					
					if (canFishMove(fishMap, nx, ny)) {//�� �� �ִ� ������ ã������ �ش� ���� ����
						nowDir = (nowDir+j)%8;
						canMove = true;
						break;
					}
					canMove = false;
				}
			}
			//8������ �� ã�Ҵµ��� ������ �� ���ٸ� ���ڸ� �״�� ����
			if (!canMove) continue;
			
			//����� �����̱�
			moveNext(fishes, fishMap, i, curX, curY, nowDir);
		}
	}

	private static boolean canFishMove(int[][] fishMap, int nx, int ny) {
		return nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && fishMap[nx][ny] != -1;
	}
	
	private static void moveNext(Fish[] fishes, int[][] fishMap, int fishNum, int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		fishes[fishNum] = new Fish(nx, ny, d, true);
		
		if (fishMap[nx][ny] != 0) {//�����̴� ��ġ�� �ٸ� ����Ⱑ �ִٸ� ���� ��ġ �ٲ��ֱ�
			switchFish(fishes, fishMap, fishNum, fishMap[nx][ny], x, y, nx, ny);
		} else {//��ĭ�̶��
			fishMap[x][y] = 0;
			fishMap[nx][ny] = fishNum;
		}
	}

	private static void switchFish(Fish[] fishes, int[][] fishMap, int moveFish, int nextFish, int x, int y, int nx, int ny) {
		//�� ���� ���� �ٲٱ�
		int temp = fishMap[x][y];
		fishMap[x][y] = fishMap[nx][ny];
		fishMap[nx][ny] = temp;
		
		//���� Fish��ü�� ���� �ٲٱ�
		fishes[nextFish] = new Fish(x, y, fishes[nextFish].d, true);
	}
	
	private static List<int[]> moveSharkNext(int[][] fishMap) {
		List<int[]> point = new ArrayList<>();	
		int cx = shark.x;
		int cy = shark.y;
		
		while (true) {//�� �� �� �ִ� ���� ��ġ ã��
			int nx = cx + dx[shark.d];
			int ny = cy + dy[shark.d];
			
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;
			if (fishMap[nx][ny] == 0) {
				cx = nx;
				cy = ny;
				continue;
			}
			point.add(new int[] {nx, ny});
			cx = nx;
			cy = ny;
		}
		return point;
	}
	

}
