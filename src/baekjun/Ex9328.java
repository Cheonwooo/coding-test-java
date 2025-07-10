package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex9328 {
	
	private static int n, m, count;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[] isKey;
	private static char[] key;
	private static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			isKey = new boolean[26];
			count = 0;
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n+2][m+2];
			 
			for (int i = 1; i < n+1; i++) {
				Arrays.fill(map[i], '.');
				String input = br.readLine();
				for (int j = 1; j < m+1; j++) {
					map[i][j] = input.charAt(j-1);
				}
			}
			
			key = br.readLine().toUpperCase().toCharArray();
			if (key[0] != '0') {
				for (int i = 0; i < key.length; i++) {
					isKey[key[i]-'A'] = true;
				}
			}
			
			while (true) {
				if (!start())break;
//				for (int i = 1; i < n+1; i++) {
//					for (int j = 1; j < m+1; j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			System.out.println(count);
		}
	}
	
	private static boolean start() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n+2][m+2];
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
	
		boolean isAgain = false;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n+2 || ny < 0 || ny >= m+2 || visited[nx][ny] || map[nx][ny] == '*') continue;
				if (Character.isUpperCase(map[nx][ny])) {//대문자라면
					if (isKey[map[nx][ny] - 'A']) {//해당하는 키가 있다면
						isAgain = true;
						map[nx][ny] = '.';
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				} else if (Character.isLowerCase(map[nx][ny])){//소문자라면 키가 있음을 체크
					isAgain = true;
					visited[nx][ny] = true;
					isKey[Character.toUpperCase(map[nx][ny]) - 'A'] = true;
					map[nx][ny] = '.';
				} else if (map[nx][ny] == '$') {
					isAgain = true;
					count++;
					map[nx][ny] = '.';
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				} else {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
				
			}
		}
		return isAgain;
	}
}
