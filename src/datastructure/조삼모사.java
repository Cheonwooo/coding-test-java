package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 21mb, 수행시간 773ms

public class 조삼모사 {
	
	private static int n, mSum, aSum, min = Integer.MAX_VALUE;
	private static int[] morning, afternoon, temp;
	private static int[][] arr;
	private static boolean[] visited, select;

	public static void main(String[] args) throws IOException{
		init();
		
		visited = new boolean[n];
		morning = new int[n/2];
		comb(0, 0, n/2);
		System.out.println(min);
	}

	private static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
	}
	
	private static void comb(int depth, int start, int r) {
		if (depth == r) {
			afternoon = new int[n/2];
			int index = 0;
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {//오전에 하는 일이 아니라면
					afternoon[index++] = i;
				}
			}
			min = Math.min(min, calculateIntensity());
			return;
		}
		
		for (int i = start; i < n; i++) {
			morning[depth] = i;
			visited[i] = true;
			comb(depth+1, i+1, r);
			visited[i] = false;
		}
	}
	
	private static int calculateIntensity() {
		temp = new int[2];
		select = new boolean[n/2];
		mSum = 0; 
		selectTwoDay(morning, select, 0, 2, 0);
		
		select = new boolean[n/2];
		aSum = 0;
		selectTwoDay(afternoon, select, 0, 2, 1);
		return (int)Math.abs(mSum - aSum);
	}

	private static void selectTwoDay(int[] day, boolean[] visited, int depth, int r, int type) {
		if (depth == r) {
			if (type == 0) {//오전
				mSum += arr[temp[0]][temp[1]];
			} else {//오후
				aSum += arr[temp[0]][temp[1]];
			}
			return;
		}
		
		for (int i = 0; i < n/2; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = day[i];
				selectTwoDay(day, visited, depth+1, r, type);
				visited[i] = false;
			}
		}
	}
}
