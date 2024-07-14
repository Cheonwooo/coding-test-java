package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex17142 {
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n, m, answer;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[] temp;
	private static boolean checkSpreadVirus;
	private static boolean[] visited;
	private static String[][] map;
	private static List<Pair> virus;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][n];
		virus = new ArrayList<>();	
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken();
				
				if (map[i][j].equals("2")) {
					virus.add(new Pair(i, j));
				}
			}
		}
		
		temp = new int[m];
		visited = new boolean[virus.size()];
		answer = Integer.MAX_VALUE;
		checkSpreadVirus = false;
		
		dfs(0, 0);
		
		if (!checkSpreadVirus) {
			answer = -1;
		}
		System.out.println(answer);
	}
	
	public static void dfs(int start, int depth) {
		if (depth == m) {
			int minCount = bfs(temp);
			if (minCount != -1) {
				checkSpreadVirus = true;
				answer = Math.min(answer, minCount);
			}
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
	
	public static int bfs(int[] temp) {
		String[][] tempMap = copyMap();
		int[][] countMap = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		Queue<Pair> q = new LinkedList<>();
		
		for (int val : temp) {
			Pair pair = virus.get(val);
			q.add(new Pair(pair.x, pair.y));
			countMap[pair.x][pair.y] = 1;
			visited[pair.x][pair.y] = true; 
		}
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int cx = pair.x;
			int cy = pair.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= n|| ny < 0 || ny >= n || visited[nx][ny]) continue;
				if (tempMap[nx][ny].equals("*")) {
					countMap[nx][ny] = countMap[cx][cy] + 1;
					visited[nx][ny] = true;
					q.add(new Pair(nx, ny));
					continue;
				}
				if (tempMap[nx][ny].equals("-") ||
						!tempMap[nx][ny].equals("0")) continue;
				countMap[nx][ny]= countMap[cx][cy] + 1;
				visited[nx][ny] = true;
				q.add(new Pair(nx, ny));
			}
		}
		
		moveCount(tempMap, countMap);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(tempMap[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		int minCount = checkMap(tempMap);
		return minCount;
	}
	
	public static String[][] copyMap() {
		String[][] tempMap = new String[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].equals("1")) {
					tempMap[i][j] = "-";//벽
				} else if (map[i][j].equals("2")) {
					tempMap[i][j] = "*";//비활성 바이러스
				} else {
					tempMap[i][j] = "0";
				}
			}
		}
		return tempMap;
	}
	
	public static void moveCount(String[][] tempMap, int[][] countMap) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!tempMap[i][j].equals("-") && !tempMap[i][j].equals("*")) {
					tempMap[i][j] = String.valueOf(countMap[i][j]);
				}
			}
		}
	}
	
	public static int checkMap(String[][] tempMap) {
		int max = 0;
		Loop:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tempMap[i][j].equals("0")) {
					max= -1;
					break Loop;
				}
				if (!tempMap[i][j].equals("-") && !tempMap[i][j].equals("*")) {
					max = Math.max(max, Integer.parseInt(tempMap[i][j])-1);
				}
			}
		}
		return max;
	}

}
