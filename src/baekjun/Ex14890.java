package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14890 {
	private static int n, l;
	private static int[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int row = canGoRowRoad();
		visited = new boolean[n][n];
		int col = canGoColRoad();
		int cantGoRoad = row + col;
		
		int answer = n*2 - cantGoRoad;
		
		System.out.println(answer);
	}
	
	public static int canGoRowRoad() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			innerLoop:
			for (int j = 0; j < n-1; j++) {
				if (arr[i][j] != arr[i][j+1]) {
					if (arr[i][j] > arr[i][j+1]) {
						if (arr[i][j] > arr[i][j+1]+1) {
							count++;
							break;
						}
						for (int k = 1; k <= l; k++) {
							if (j+k >= n) {
								count++;
								break innerLoop;
							}
							if (visited[i][j+k]) {
								count++;
								break innerLoop;
							}
							if (arr[i][j+k]+1 > arr[i][j]) {
								count++;
								break innerLoop;
							}
							visited[i][j+k] = true;
						}
					} else if (arr[i][j] < arr[i][j+1]) {
						if(arr[i][j+1] > arr[i][j]+1) {
							count++;
							break;
						}
						for (int k = 1; k <= l; k++) {
							if (j+1-k < 0) {
								count++;
								break innerLoop;
							}
							if (visited[i][j+1-k]) {
								count++;
								break innerLoop;
							}
							if (arr[i][j+1-k]+1 > arr[i][j+1]) {
								count++;
								break innerLoop;
							}
							visited[i][j+1-k] = true;
						}
					}
				}
			}
		}
		return count;
	}
	
	public static int canGoColRoad() {
		int count = 0;
		for (int j = 0; j < n; j++) {
			innerLoop:
			for (int i = 0; i < n-1; i++) {
				if (arr[i][j] != arr[i+1][j]) {
					if (arr[i][j] > arr[i+1][j]) {
						if (arr[i][j] > arr[i+1][j]+1) {
							count++;
							break;
						}
						for (int k = 1; k <= l; k++) {
							if (i+k >= n) {
								count++;
								break innerLoop;
							}
							if (visited[i+k][j]) {
								count++;
								break innerLoop;
							}
							if (arr[i+k][j]+1 > arr[i][j]) {
								count++;
								break innerLoop;
							}
							visited[i+k][j] = true;
						}
					} else if (arr[i][j] < arr[i+1][j]) {
						if(arr[i+1][j] > arr[i][j]+1) {
							count++;
							break;
						}
						for (int k = 1; k <= l; k++) {
							if (i+1-k < 0) {
								count++;
								break innerLoop;
							}
							if (visited[i+1-k][j]) {
								count++;
								break innerLoop;
							}
							if (arr[i+1-k][j]+1 > arr[i+1][j]) {
								count++;
								break innerLoop;
							}
							visited[i+1-k][j] = true;
						}
					}
				}
			}
		}
		return count;
	}
}
