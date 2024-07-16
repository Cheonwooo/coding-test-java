package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex17779 {
	public static int min = Integer.MAX_VALUE;
	public static int[][] population, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		population = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int x = 1; x <= 18; x++) {
			for (int y = 2; y <= 19; y++) {
				for (int d1 = 1; d1 <= n-2; d1++) {
					for (int d2 = 1; d2 <= n-2; d2++) {
						if (x - d1 > n || x - d2 > n || y - d1 < 1 || y + d2 > n
								|| x + d1 + d2 > n) continue;
						temp = new int[n+1][n+1];
						makeFlag(x, y, d1, d2);
						fillFiveFlag(n);
						fillOtherFlags(n, x, y, d1, d2);
						calculateMinValue(n);
//						printMap(n);
					}
				}
			}
		}
		System.out.println(min);
	}
	
	public static void makeFlag(int x, int y, int d1, int d2) {
		temp[x][y] = 5;
		for (int i = 1; i <= d1; i++) {
			temp[x+i][y-i] = 5;
			temp[x+d2+i][y+d2-i] = 5;
		}
		
		for (int i = 1; i <= d2; i++) {
			temp[x+i][y+i] = 5;
			temp[x+d1+i][y-d1+i] = 5;
		}
	}
	
	public static void fillFiveFlag(int n) {
		
		for (int i = 1; i <= n; i++) {
			int left = -1;
			int right = -1;
			
			for (int j = 1; j <= n; j++) {
				if (left == -1 && temp[i][j] == 5) {
					left = j;
					continue;
				}
				
				if (left != -1 && temp[i][j] == 5) right = j;
				
				if (left != -1 && right != -1) {
					for (int k = left; k <= right; k++) {
						temp[i][k] = 5;
					}
					break;
				}
			}
		}
	}
	
	public static void fillOtherFlags(int n, int x, int y, int d1, int d2) {
		for (int i = 1; i < x + d1; i++) {
			for (int j = 1; j <= y; j++) {
				if (temp[i][j] == 0) temp[i][j] = 1;
			}
		}
		
		for (int i = 1; i <= x + d2; i++) {
			for (int j = y+1; j <= n; j++) {
				if (temp[i][j] == 0) temp[i][j] = 2;
			}
		}
		
		for (int i = x + d1; i <= n; i++) {
			for (int j = 1; j < y - d1 + d2; j++) {
				if (temp[i][j] == 0) temp[i][j] = 3;
			}
		}
		
		for (int i = x + d2; i <= n; i++) {
			for (int j = y - d1 + d2; j <= n; j++) {
				if (temp[i][j] == 0) temp[i][j] = 4;
			}
		}
	}
	
	public static void calculateMinValue(int n) {
		int[] sum = new int[6];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum[temp[i][j]] += population[i][j];
			}
		}
		
		Arrays.sort(sum);
		min = Math.min(min, sum[5] - sum[1]);
	}
	
//	public static void printMap(int n) {
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(temp[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}