package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex17136 {
	
	private static int answer = Integer.MAX_VALUE;
	private static int[] paperCount = new int[6];
	private static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(paperCount, 5);
		dfs(0, 0, 0);
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}
	
	private static void dfs(int x, int y, int count) {
		if (x >= 9 && y > 9) {
			answer = Math.min(answer, count);
			return;
		}
		
		if (answer <= count) {
			return;
		}
		
		if (y > 9) {
			dfs(x + 1, 0, count);
			return;
		}
		
		if (arr[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (paperCount[i] > 0 && isAttatch(x, y, i)) {
					attachPaper(x, y, i, 0);
					paperCount[i]--;
					dfs(x, y + 1, count + 1);
					attachPaper(x, y, i, 1);
					paperCount[i]++;
				}
			}
		} else {
			dfs(x, y + 1, count);
		}
	}

	private static void attachPaper(int x, int y, int n, int flag) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				arr[i][j] = flag;
			}
		}
	}
	
	private static boolean isAttatch(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
