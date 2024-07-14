package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex17142_2 {
	public static class Pair {
		int x;
		int y;
		int time;
		
		public Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	private static int n, m, answer, emptyCount = 0;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[] temp;
	private static int[][] map;
	private static boolean[] visited;
	private static List<Pair> virus;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		virus = new ArrayList<>();	
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) {
					virus.add(new Pair(i, j, 0));
				} else if (map[i][j] == 0) {
					emptyCount++;
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		visited = new boolean[virus.size()];
		temp = new int[m];
		if (emptyCount == 0) {
			System.out.println(0);
		} else { 
			dfs(0, 0);
			if (answer == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(answer);
			}
		}
	}
	
	public static void dfs(int start, int depth) {
		if (depth == m) {
			bfs(emptyCount);
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void bfs(int emptySpace) {
		boolean[][] visited = new boolean[n][n];
		Queue<Pair> q = new LinkedList<>();
		
		for (int val : temp) {
			Pair pair = virus.get(val);
			q.add(new Pair(pair.x, pair.y, pair.time));
			visited[pair.x][pair.y] = true; 
		}
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int cx = pair.x;
			int cy = pair.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n|| ny < 0 || ny >= n ||
						visited[nx][ny] || map[nx][ny] == 1) continue;
				
				if (map[nx][ny] == 0) {
					emptySpace--;
				}
				
				if (emptySpace == 0) {
					answer = Math.min(pair.time+1, answer);
					return;
				}
				
				visited[nx][ny] = true;
				q.add(new Pair(nx, ny, pair.time+1));
			}
		}
	}
}