package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16945 {
	
	private static int min = Integer.MAX_VALUE;
	private static int[][] arr, temp;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		temp = new int[3][3];
		visited = new boolean[10];
		comb(0, 0);
		System.out.println(min);
	}
	
	private static void comb(int depth, int cost) {
		if (depth == 9) {
			if (isMagicSquare()) {
				min = Math.min(min ,cost);
			}
			return;
		}
		
		int x = depth/3;
		int y = depth%3;
		for (int i = 1; i < 10; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int tempNum = temp[x][y];
				temp[x][y] = i;
				comb(depth + 1, cost + Math.abs(arr[x][y] - temp[x][y]));
				visited[i] = false;
				temp[x][y] = tempNum;
			}
		}
	}
	
	private static boolean isMagicSquare() {
		//행, 열
		for (int i = 0; i < 3; i++) {
			int sumRow = 0;
			int sumCol = 0;
			for (int j = 0; j < 3; j++) {
				sumRow += temp[i][j];
				sumCol += temp[j][i];
			}
			if (sumRow != 15 || sumCol != 15) return false;
		}
		
		//대각선
		int sumCross = 0;
		int sumReverseCross = 0;
		for (int i = 0; i < 3; i++) {
			sumCross += temp[i][i];
			sumReverseCross += temp[i][2-i];
		}
		
		if (sumCross != 15 || sumReverseCross != 15) return false;
		
		return true;
	}
}

