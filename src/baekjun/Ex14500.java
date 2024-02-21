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
	private static int n, m, max = Integer.MIN_VALUE;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	
	private static void dfs(int x, int y, int sum, int depth) {
		if (depth == 4) { 
			max = Math.max(sum, max);
			return;
		}
		
		for (int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
			
			if (!visited[nx][ny]) {
				if (depth == 2) {
					visited[nx][ny] = true;
					dfs(x, y, sum + arr[nx][ny], depth+1);
					visited[nx][ny] = false;
				}
				visited[nx][ny] = true;
				dfs(nx, ny, sum + arr[nx][ny], depth+1);
				visited[nx][ny] = false;
			}
			
		}
	}
}
