package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex25682 {
	
	private static int n, m, k;
	private static char[][] chessMap;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		chessMap = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			chessMap[i] = br.readLine().toCharArray();
		}
		
		int[][] whiteMap = new int[n+1][m+1];
		int[][] blackMap = new int[n+1][m+1];
		
		//첫 칸이 W인 경우
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
				char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';
				
				whiteMap[i][j] = (chessMap[i-1][j-1] == expectedW) ? 0 : 1;
				blackMap[i][j] = (chessMap[i-1][j-1] == expectedB) ? 0 : 1;
			}
		}

		//누적합 구하기
		calculatePrefixSum(whiteMap);
		calculatePrefixSum(blackMap);
		
		int black = calculateMinColor(blackMap);
		int white = calculateMinColor(whiteMap);
		
		System.out.println(Math.min(black, white));
	}
	
	private static void calculatePrefixSum(int[][] map) {
		//가로 누적합
		for (int i = 1; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				map[i][j] += map[i][j-1];
			}
		}
		
		//세로 누적합
		for (int i = 1; i <= m; i++) {
			for (int j = 2; j <= n ;j++) {
				map[j][i] += map[j-1][i];
			}
		}
	}
	
	private static int calculateMinColor(int[][] map) { 
		int color = 10_000_000;
		for (int i = 1; i <= n-k+1; i++) {
			for (int j = 1; j <= m-k+1; j++) {
				int colorCount = map[i+k-1][j+k-1] - (map[i+k-1][j-1] + map[i-1][j+k-1] - map[i-1][j-1]);
				color = Math.min(colorCount, color);
			}
		}
		return color;
	}
}
