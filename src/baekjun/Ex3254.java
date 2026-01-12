package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3254 {
	
	private static int[] dx = {-1, -1, 0, 1};
	private static int[] dy = {0, 1, 1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[6][7];
		for (int i = 0; i < 21; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int colS = Integer.parseInt(st.nextToken()) - 1;
			int colJ = Integer.parseInt(st.nextToken()) - 1;
			
			fillArr(arr, colS, 1);
			if (isFourGimbab(arr, 1)) {
				System.out.println("sk " + (i + 1));
				return;
			}
			
			fillArr(arr, colJ, 2);
			if (isFourGimbab(arr, 2)) {
				System.out.println("ji " + (i + 1));
				return;
			}
		}
		System.out.println("ss");
	}
	private static void fillArr(int[][] arr, int col, int flag) {
		for (int i = 5; i >= 0; i--) {
			if (arr[i][col] == 0) {
				arr[i][col] = flag;
				break;
			}
		}
	}

	private static boolean isFourGimbab(int[][] arr, int flag) {
		for (int i = 0; i < 7; i++) {
			for (int j = 5; j >= 0; j--) {
				if (arr[j][i] == flag) {
					if (checkFourGimbab(arr, i, j, flag)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean checkFourGimbab(int[][] arr, int y, int x, int flag) {
		for (int i = 0; i < 4; i++) {
			int cx = x;
			int cy = y;
			
			int count = 1;
			while (true) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || nx >= 6 || ny < 0 || ny >= 7 || arr[nx][ny] != flag) break;
				count++;
				cx = nx;
				cy = ny;
				if (count == 4) return true; 
			}
		}
		return false;
	}
}
