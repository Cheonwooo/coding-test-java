package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 플루이드 워셜
 * 모든 정점에서 최소 거리를 구하기
 */

public class Ex42861_floydWarshallExercise {
	private static int INF = (int) 1e9;
	private static int[][] arr = new int[501][501];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 501; i++) {
			Arrays.fill(arr[i], INF);
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (i == j) arr[i][j] = 0;
			}
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a][b] = c;
		}
		
		for (int k = 1; k < n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (arr[i][j] == INF) {
					System.out.print("INFINITY ");
				} else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
