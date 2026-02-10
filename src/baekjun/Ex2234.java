package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2234 {
	
	private static int n, m;
	private static int[] dx = {0, -1, 0, 1};
	private static int[] dy = {-1, 0, 1, 0};
	private static int[][] arr, indexMap;
	private static Map<Integer, Integer> area = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		indexMap = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int roomIndex = 1;
		int maxSize = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (indexMap[i][j] == 0) {
					area.put(roomIndex, bfs(i, j, roomIndex));
					maxSize = Math.max(maxSize, area.get(roomIndex++));
				}
			}
		}
		System.out.println(roomIndex - 1);
		System.out.println(maxSize);
		
		int maxAreaAfterBreaking = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				maxAreaAfterBreaking = Math.max(breakWall(i, j), maxAreaAfterBreaking);
			}
		}
		System.out.println(maxAreaAfterBreaking);
	}
	
	private static int bfs(int x, int y, int index) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		indexMap[x][y] = index;
		boolean[][] visited = new boolean[n][m];
		visited[x][y] = true;
		
		int count = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (checkWall(cx, cy, i) && !visited[nx][ny]) {
					count++;
					indexMap[nx][ny] = index;
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return count;
	}
	
	private static boolean checkWall(int x, int y, int d) {
		return (arr[x][y] & (1 << d)) == 0;
	}
	
	private static int breakWall(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if(indexMap[nx][ny] != indexMap[x][y]) {
					return area.get(indexMap[nx][ny]) + area.get(indexMap[x][y]);
				}
			}
		}
		return 0;
	}
}
