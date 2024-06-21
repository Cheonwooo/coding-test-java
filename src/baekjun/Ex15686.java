package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex15686 {
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n, m, min = Integer.MAX_VALUE;
	private static int[] temp;
	private static int[][] map;
	private static boolean[] visited;
	private static List<Pair> chickens;
	private static List<Pair> homes;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		chickens = new ArrayList<>();
		homes = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					homes.add(new Pair(i, j));
				} else if (map[i][j] == 2) {
					chickens.add(new Pair(i, j));
				}
			}
		}
		
		temp = new int[m];
		visited = new boolean[chickens.size()];
		dfs(0, 0);
		System.out.println(min);
	}
	
	public static void dfs(int depth, int start) {
		if (depth == m) {
			min = Math.min(min, calculateDistance(temp));
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				dfs(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	public static int calculateDistance(int[] temp) {
		int sum = 0;
		for (int i = 0; i < homes.size(); i++) {
			Pair home = homes.get(i);
			int minDistance = Integer.MAX_VALUE;
			
			for (int j = 0; j < temp.length; j++) {
				Pair chicken = chickens.get(temp[j]);
				minDistance = Math.min(minDistance, 
						(int)Math.abs(home.x - chicken.x) +
						(int)Math.abs(home.y - chicken.y));
			}
			sum += minDistance;
		}
		return sum;
	}

}
