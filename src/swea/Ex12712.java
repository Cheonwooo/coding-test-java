package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12712 {
	private static int n, m;
	private static int[][] map;
	private static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	private static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			sb.append("#" + (t+1) + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			
			int max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, killFly(i, j));
				}
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int killFly(int x, int y) {
		//+모양
		int sumA = map[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			int count = 1;
			
			while (count < m) {
				int cx = nx + dx[i];
				int cy = ny + dy[i];
				
				if (cx < 0 || cx >=n || cy < 0 || cy >= n) break;
				
				sumA += map[cx][cy];
				nx = cx;
				ny = cy;
				count++;
			}
		}
		
		//x모양
		int sumB = map[x][y];
		
		for (int i = 4; i < 8; i++) {
			int nx = x;
			int ny = y;
			int count = 1;
			
			while (count < m) {
				int cx = nx + dx[i];
				int cy = ny + dy[i];
				
				if (cx < 0 || cx >=n || cy < 0 || cy >= n) break;
				
				sumB += map[cx][cy];
				nx = cx;
				ny = cy;
				count++;
			}
		}
		
		return Math.max(sumA, sumB);
	}

}

