package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex16946 {
	
	private static int n, m;
	private static int[][] arr, tempArr;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static List<int[]> road;
	private static Map<Integer, Integer> island = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		tempArr = new int[n][m];
		
		List<int[]> walls = new ArrayList<>();
		road = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j) - '0';
				if (arr[i][j] == 1) walls.add(new int[] {i, j});
				else road.add(new int[] {i, j});
			}
		}
		
		int index = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && tempArr[i][j] == 0) {
					island.put(index, markFlag(i, j, index));
					index++;
				}
			}
		}
		
//		for (int i = 0; i < road.size(); i++) {
//			int[] cur = road.get(i);
//			
//			int cx = cur[0];
//			int cy = cur[1];
//			if (tempArr[cx][cy] == 0) {
//				int count = markFlag(cx, cy, i+1);
//				island.put(i+1, count);
//			}
//		}
		
		int[][] answer = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					sb.append(calculateMovingBlank(i, j) % 10);
				} else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static int markFlag(int x, int y, int flag) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		tempArr[x][y] = flag;
		
		int count = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (arr[nx][ny] == 0 && tempArr[nx][ny] == 0) {
					tempArr[nx][ny] = flag;
					count++;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return count;
	}
	
	private static int calculateMovingBlank(int x, int y) {
		Set<Integer> set = new HashSet<>();
		int count = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 1 || tempArr[nx][ny] == 0) continue;
			set.add(tempArr[nx][ny]);
		}
		
		for (int num : set) {
			count += island.get(num);
		}
		return count;
	}
}

