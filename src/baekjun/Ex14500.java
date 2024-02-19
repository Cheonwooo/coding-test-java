package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어
 * 5개의 테트로미노를 배열로 저장
 * 90도 회전 시킨 후 0,0부터 n,m까지 합 구하기 
 * 끝까지 다 구했으면 90도 회전 시킨 후 합 후하기
 * 대칭한 후 위 과정 똑같이 반복
 * 
 * 시간복잡도
 * n * m * 2 * 4 * 5
 * 
 * 자료구조
 * 테트로미노의 좌표를 저장할 int[][]
 * 입력값을 저장할 int[][]
 * 방향값을 저장할 int[] 2개
 * 
 */

public class Ex14500 {
	private static int n, m;
	prviate static int[][] arr;
	private static int[][][] tetromino = {
			{{0,0}, {0,1}, {0,2}, {0,3}},
			{{0,0}, {0,1}, {1,0}, {1,1}},
			{{0,0}, {1,0}, {2,0}, {2,1}},
			{{0,0}, {1,0}, {1,1}, {2,1}},
			{{0,0}, {0,1}, {0,2}, {1,1}}
	};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	
	private static void moveTetro() {
		int max = 0;
		for (int i = 0; i < tetromino.length; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					int sum = calculateSum(i, j, k);
					max = Math.max(sum, max);
				}
			}
		}
	}
	
	private static int calculateSum(int seq, int x, int y) {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + tetromino[seq][i][0];
			int ny = y + tetromino[seq][i][1];
			
			sum += arr[nx][ny];
		} 
		return sum;
	}
}
