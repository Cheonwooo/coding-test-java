package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16234 {
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n, L, R;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][] map, temp;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		while (true) {
			boolean check = false;
			temp = new int[n][n];
			visited = new boolean[n][n];
			copyMap(temp, map);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					List<Pair> list = new ArrayList<>();
					
					int sum = bfs(list, i, j);
					if (list.size() != 1) {
						check = true;
						dividePopulation(list, sum);
					}
				}
			}

			if (check) {
				answer++;
				copyMap(map, temp);
			} else break;
			
		}
		System.out.println(answer);
	}
	
	public static void copyMap (int[][] arrA, int[][] arrB) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arrA[i][j] = arrB[i][j];
			}
		}
	}
	
	public static int bfs(List<Pair> list, int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		int sum = map[x][y];
		visited[x][y] = true;
		list.add(new Pair(x, y));
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int cx = pair.x;
			int cy = pair.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
				
				int sub = (int)Math.abs(map[cx][cy] - map[nx][ny]);
				if (sub >= L && sub <= R) {
					visited[nx][ny] = true;
					sum += map[nx][ny];
					q.add(new Pair(nx, ny));
					list.add(new Pair(nx, ny));
				}
			}
		}
		return sum;
	}
	
	public static void dividePopulation(List<Pair> list, int sum) {
		int size = list.size();
		int sub = sum / size;
		for (int i = 0; i < size; i++) {
			Pair pair = list.get(i);
			temp[pair.x][pair.y] = sub; 
		}
	}
}
