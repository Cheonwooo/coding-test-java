package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12100 {
	private static int n, max;
	private static int[] dir = {0, 1, 2, 3};
	private static int[] temp = new int[5];
	private static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		comb(0);
		System.out.println(max);
	}
	
	public static void comb(int depth) {
		if (depth == 5) {
			play2048(temp);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			temp[depth] = dir[i];
			comb(depth+1);
		}
	}
	
	public static void play2048(int[] temp) {
		int[][] copyArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < temp.length; i++) {
			move(copyArr, temp[i]);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(copyArr[i][j], max);
			}
		}
//		
//		for (int i = 0; i < temp.length; i++) {
//			System.out.print(temp[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(copyArr[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
	}
	
	public static void move(int[][] copyArr, int dir) {
		if (dir == 0) {
			moveUp(copyArr);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n-1; j++) {
					if (copyArr[j][i] == copyArr[j+1][i]) {
						copyArr[j][i] *= 2;
						copyArr[j+1][i] = 0;
					}
				}
			}
			moveUp(copyArr);
		} else if (dir == 1) {
			moveRight(copyArr);
			for (int i = 0; i < n; i++) {
				for (int j = n-1; j >= 1; j--) {
					if (copyArr[i][j] == copyArr[i][j-1]) {
						copyArr[i][j] *= 2;
						copyArr[i][j-1] = 0;
					}
				}
			}
			moveRight(copyArr);
		} else if (dir == 2) {
			moveDown(copyArr);
			for (int i = 0; i < n; i++) {
				for (int j = n-1; j >= 1; j--) {
					if (copyArr[j][i] == copyArr[j-1][i]) {
						copyArr[j][i] *= 2;
						copyArr[j-1][i] = 0;
					}
				}
			}
			moveDown(copyArr);
		} else if (dir == 3){
			moveLeft(copyArr);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n-1; j++) {
					if (copyArr[i][j] == copyArr[i][j+1]) {
						copyArr[i][j] *= 2;
						copyArr[i][j+1] = 0;
					}
				}
			}
			moveLeft(copyArr);
		}
	}
	
	public static void moveUp(int[][] copyArr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copyArr[j][i] != 0) {
					int index = j;
					while (true) {
						index--;
						if (index < 0) break;
						
						if (copyArr[index][i] != 0) break;
						
						copyArr[index][i] = copyArr[index+1][i];
						copyArr[index+1][i] = 0;
					}
				}
			}
		}
	}
	
	public static void moveRight(int[][] copyArr) {
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j >= 0; j--) {
				if (copyArr[i][j] != 0) {
					int index = j;
					while (true) {
						index++;
						if (index >= n) break;
						
						if (copyArr[i][index] != 0) break;
						
						copyArr[i][index] = copyArr[i][index-1];
						copyArr[i][index-1] = 0;
					}
				}
			}
		}
	}
	
	public static void moveDown(int[][] copyArr) {
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j >= 0; j--) {
				if (copyArr[j][i] != 0) {
					int index = j;
					while (true) {
						index++;
						if (index >= n) break;
						
						if (copyArr[index][i] != 0) break;
						
						copyArr[index][i] = copyArr[index-1][i];
						copyArr[index-1][i] = 0;
					}
				}
			}
		}
	}
	
	public static void moveLeft(int[][] copyArr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copyArr[i][j] != 0) {
					int index = j;
					while (true) {
						index--;
						if (index < 0) break;
						
						if (copyArr[i][index] != 0) break;
						
						copyArr[i][index] = copyArr[i][index+1];
						copyArr[i][index+1] = 0;
					}
				}
			}
		}
	}
}
