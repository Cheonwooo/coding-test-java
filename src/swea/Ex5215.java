package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400
 */

public class Ex5215 {
	private static int max, minCal, limitCal;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int ingredientCount = Integer.parseInt(st.nextToken());
			limitCal = Integer.parseInt(st.nextToken());
			int[][] ingredients = new int[ingredientCount][2];
			
			minCal = Integer.MAX_VALUE;
			for (int j = 0; j < ingredientCount; j++) {
				st = new StringTokenizer(br.readLine());
				
				ingredients[j][0] = Integer.parseInt(st.nextToken());
				ingredients[j][1] = Integer.parseInt(st.nextToken());
				
				minCal = Math.min(minCal, ingredients[j][1]);
			}
			
			max = Integer.MIN_VALUE;
			visited = new boolean[ingredients.length];
			for (int j = 0; j <= ingredientCount; j++) {
				dfs(ingredients, 0, 0, 0, j);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int[][] ingredients, int calSum, int score, int start, int depth) {
		if (depth == 0 && calSum <= limitCal) {
			max = Math.max(score, max);
			return;
		}
		
		for (int i = start; i < ingredients.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(ingredients, calSum + ingredients[i][1], score + ingredients[i][0], i+1, depth-1);
				visited[i] = false;
			}
		}
	}
}
