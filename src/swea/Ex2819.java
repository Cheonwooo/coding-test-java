package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex2819 {
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[] map;
	private static int[][] arr;
	private static Set<String> set;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			set = new HashSet<>();
			
			arr = new int[4][4];
			map = new int[7];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 0);
				}
			}
			sb.append(set.size()).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y, int depth) {
		if (depth == 7) {
			String number = "";
			for (int val : map) {
				number += String.valueOf(val);
			}
			set.add(number);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			
			map[depth] = arr[nx][ny];
			dfs(nx, ny, depth+1);
		}
	}

}
