package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 76588kb, 시간 392ms

public class Ex16724 {
	
	private static int n, m, index = 1, answer = 0;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map, visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				char dir = str.charAt(j);
				
				if (dir == 'U') { 
					map[i][j] = 0;
				} else if (dir == 'D') {
					map[i][j] = 2;
				} else if (dir == 'R') {
					map[i][j] = 1;
				} else if (dir == 'L') {
					map[i][j] = 3;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0) {
					makeSafeZone(i, j);
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void makeSafeZone(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = index;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			int dir = map[cx][cy];

			int nx = cx + dx[dir];
			int ny = cy + dy[dir];
			
			//새로 가는 길이라면
			if (visited[nx][ny] == 0) {
				visited[nx][ny] = index;
				q.offer(new int[] {nx, ny});
			} else {//이미 한 번 탐색했던 길일 떄
				if (visited[nx][ny] == index) {//같은 인덱스라면 하나의 싸이클임
					answer++;
				}
				index++;
				break;
			}
		}
	}
}
