package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아이디어
 * 한곳을 기준으로 네방향을 모두 바꾼 후 그때의 최댓값 저장해놓기
 * 2중 for문으로 한포인트씩 순회하기
 * 한 포인트에서 네방향을 순서대로 값을 바꾸기
 * temp[][]를 따로 만들고 원래의 배열값을 계속 초기화
 * 
 * 시간복잡도
 * n * n * 4
 * 
 * 자료구조
 * 입력값을 저장할 char[][]
 * 입력값을 옴길 char[][]
 * 방향값을 저장할 int[] * 2
 * 최댓값을 저장할 int
 * 
 */

public class Ex3085 {
	private static int n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0 ,-1};
	private static char[][] candy, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		candy = new char[n][n];
		temp = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < n; j++) {
				candy[i][j] = str.charAt(j);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, calculateMax(i,j));
			}
		}
		System.out.println(max);
	}
	
	private static int calculateMax(int x, int y) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
			
			copyCandy();
			changeSpot(x, y, nx, ny);
			
			max = Math.max(max, calculateEatCandy());
		}
		
		return max;
	}
	
	private static void copyCandy() {
		for (int i = 0; i < n; i++) {			
			for (int j = 0; j < n; j++) {
				temp[i][j] = candy[i][j];
			}
		}
	}
	
	private static void changeSpot(int x, int y, int nx, int ny) {
		char tmp = temp[x][y];
		temp[x][y] = temp[nx][ny];
		temp[nx][ny] = tmp;
	}
	
	private static int calculateEatCandy() {
		int max = 0;
		
		//행
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = 0; j < n-1; j++) {
				if (temp[i][j] == temp[i][j+1]) {
					count++;
					max = Math.max(max, count);
				} else {
					count = 1;
				}
			}
		}
		
		//열
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = 0; j < n-1; j++) {
				if (temp[j][i] == temp[j+1][i]) {
					count++;
					max = Math.max(max, count);
				} else {
					count = 1;
				}
			}
		}
		
		return max;
	}
}
