package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17135 {
	
	private static int n, m, d, max = Integer.MIN_VALUE;
	private static int[] temp;
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		temp = new int[3];
		map = new int[n+1][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		selectArcher(0, 0);
		System.out.println(max);
	}
	
	public static void selectArcher(int depth, int start) {
		if (depth == 3) {
			int[][] tempMap = new int[n+1][m];
			for (int i = 0; i < n; i++) {
				System.arraycopy(map[i], 0, tempMap[i], 0, m);
			}
			int killEnemy = gameStart(tempMap, temp);
			max = Math.max(max, killEnemy);
			return;
		}
		
		for (int i = start; i < m; i++) {
			temp[depth] = i;
			selectArcher(depth+1, i+1);
		}
	}

	public static int  gameStart(int[][] tempMap, int[] temp) {
		int kill = 0;
		int turn = n;
		
		while (turn-- >= 0) {
			boolean[][] enemy = new boolean[n][m];
			
			for (int i = 0; i < temp.length; i++) {
				int nx = n;
				int ny = temp[i];
				
				int tempX = Integer.MAX_VALUE;
				int tempY = Integer.MAX_VALUE;
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < m; j++) {
					for (int k = n-1; k >= 0; k--) {
						if (tempMap[k][j] == 1) {
							int dist = Math.abs(nx - k) + Math.abs(ny - j);
							if (dist <= d && dist < min) {
								min = dist;
								tempX = k;
								tempY = j;
							}
						}
					}
				}
				
				//못 죽였다면
				if (tempX == Integer.MAX_VALUE && tempY == Integer.MAX_VALUE) continue;
				enemy[tempX][tempY] = true;
			}
			
			//죽인 적의 위치 맵에서 0으로 바꾸기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (enemy[i][j]) {
						kill++;
						tempMap[i][j] = 0;
					}
				}
			}
			
			//한칸씩 내리기
			for (int i = 0; i < m; i++) {
				for (int j = n-1; j >= 0; j--) {
					if (j == 0) {
						tempMap[j][i] = 0;
					} else {
						tempMap[j][i] = tempMap[j-1][i];
					}
				}
			}
		}
		return kill;
	}
}
