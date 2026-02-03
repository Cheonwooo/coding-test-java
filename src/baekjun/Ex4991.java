package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex4991 {
	
	private static int n, m, answer;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] distList; 
	private static int[][] distMap;
	private static boolean[] visited;
	private static char[][] map;
	private static List<int[]> dirtyRooms;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if (m == 0 && n == 0) break;
			
			dirtyRooms = new ArrayList<>();
			map = new char[n][m];
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < m; j++) {
					map[i][j] = input[j].charAt(0);
					if (map[i][j] == 'o') {
						dirtyRooms.add(0, new int[] {i, j});
					} else if (map[i][j] == '*') {
						dirtyRooms.add(new int[] {i, j});
					}
				}
			}
			
			boolean checkOut = false;
			int size = dirtyRooms.size();
			distList = new int[size][size];
			for (int i = 0; i < size; i++) {
				distMap = new int[n][m];
				int[] start = dirtyRooms.get(i);
				
				findMinDist(start[0], start[1]);
				
				for (int j = 0; j < size; j++) {
					if (i == j) continue;
					int[] end = dirtyRooms.get(j);
					
					distList[i][j] = distMap[end[0]][end[1]];
					if (distList[i][j] == 0) checkOut = true;
				}
				if (checkOut) break;
			}
			
			if (checkOut) {
				sb.append(-1 + "\n");
				continue;
			}
			
			answer = Integer.MAX_VALUE;
			calculateMinDist();
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

	private static void calculateMinDist() {
		int size = dirtyRooms.size();
		visited = new boolean[size];
		selectCleanSeq(0, 0, 0);
	}
	
	private static void selectCleanSeq(int depth, int start, int totalDist) {
		if (totalDist > answer) return;
		
		if (depth == dirtyRooms.size()) {
			answer = Math.min(answer, totalDist);
			return;
		}
		
		for (int i = 0; i < dirtyRooms.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				selectCleanSeq(depth+1, i, totalDist + distList[start][i]);
				visited[i] = false;
			}
		}
	}

	private static void findMinDist(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] check = new boolean[n][m];
		check[sx][sy] = true;
		q.offer(new int[] {sx, sy});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n|| ny < 0 || ny >= m ||
						check[nx][ny] || map[nx][ny] == 'x') continue;
				check[nx][ny] = true;
				distMap[nx][ny] = distMap[cx][cy] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}
