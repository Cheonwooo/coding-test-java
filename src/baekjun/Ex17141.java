package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex17141 {
	
	private static int n, m, answer = Integer.MAX_VALUE;
	private static int[] temp;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map, spreadMap;
	private static List<int[]> virusPos = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		spreadMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) {
					virusPos.add(new int[] {i, j});
				} else if (map[i][j] == 1) {
					spreadMap[i][j] = -1;
				}
			}
		}
		
		temp = new int[m];
		selectVirusPos(0, 0);
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}
	
	private static void selectVirusPos(int depth, int start) {
		if (depth == m) {
			int[][] copyMap = new int[n][n];
			copySpreadMap(copyMap);
			makeVirusPointAndSpread(copyMap);
			int maxTime = findMaxTime(copyMap);
			if (maxTime != -1) {
				answer = Math.min(answer, maxTime);
			}
			return;
		}
		
		for (int i = start; i < virusPos.size(); i++) {
			temp[depth] = i;
			selectVirusPos(depth + 1, i + 1);
		}
	}
	
	private static void copySpreadMap(int[][] copyMap) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copyMap[i][j] = spreadMap[i][j];
			}
		}
	}
	
	private static void makeVirusPointAndSpread(int[][] copyMap) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < temp.length; i++) {
			int[] pos = virusPos.get(temp[i]);

			int x = pos[0];
			int y = pos[1];
			
			copyMap[x][y] = 1;
			q.offer(new int[] {x, y});
			visited[x][y] = true;
		}
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || copyMap[nx][ny] == -1) continue;
				visited[nx][ny] = true;
				copyMap[nx][ny] = copyMap[cx][cy] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	private static int findMaxTime(int[][] copyMap) {
		int maxTime = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copyMap[i][j] == 0) return -1;
				else {
					maxTime = Math.max(maxTime, copyMap[i][j]);
				}
			}
		}
		return maxTime - 1;
	}
}
