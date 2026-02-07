package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Ex1941 {
	
	private static int answer = 0;
	private static List<int[]> somPos = new ArrayList<>();
	private static int[] temp = new int[7];
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static char[][] arr;
	private static boolean[] visited = new boolean[25];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[5][5];
		for (int i = 0; i < 5; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				arr[i][j] = input[j];
				if (arr[i][j] == 'S') {
					somPos.add(new int[] {i, j});
				}
			}
		}
		
		if (somPos.size() < 4) {
			System.out.println(0);
			return;
		}
		
		comb(0, 0, 0);
		
		System.out.println(answer);
	}

	private static void comb(int depth, int start, int somCount) {
		if (depth - somCount > 3) return;
		
		if (depth == 7) {
			bfs(temp[0] / 5, temp[0] % 5);
			return;
		}
		
		for (int i = start; i < 25; i++) {
			int row = i / 5;
			int col = i % 5;
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				if (arr[row][col] == 'S') {
					comb(depth + 1, i+1, somCount + 1);
				} else {
					comb(depth + 1, i+1, somCount);
				}
				visited[i] = false;
			}
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		boolean[][] check = new boolean[5][5];
		check[x][y] = true;
		
		int count = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				int next = nx * 5 + ny;
				if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || check[nx][ny]) continue;
				if (visited[next]) {
					check[nx][ny] = true;
					q.offer(new int[] {nx, ny});
					count++;
				}
			}
		}
		if (count == 7) answer++;
	}
}
