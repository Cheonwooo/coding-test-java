package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex16235 {
	private static int n, m, k;
	private static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	private static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	private static int[][] foods, remainFoods;
	private static List<Integer>[][] tree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		foods = new int[n][n];
		remainFoods = new int[n][n];
		tree = new List[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				foods[i][j] = Integer.parseInt(st.nextToken());
				remainFoods[i][j] = 5;
				tree[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			
			tree[x][y].add(age);
		}
		
		while (k > 0) {
			springAndSummer();
			fall();
			winter();
			k--;
		}
		
		int answer = checkLiveTrees();
		System.out.println(answer);
	}

	public static void springAndSummer() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int food = remainFoods[i][j];
				remainFoods[i][j] = 0;
				int transFood = 0;
				
				Collections.sort(tree[i][j]);
				
				int size = tree[i][j].size();
				for (int k = 0; k < size; k++) {
					int treeAge = tree[i][j].get(0); 
					
					if (food < treeAge) {
						transFood += treeAge / 2;
					} else {
						tree[i][j].add(treeAge + 1);
						food -= treeAge;
					}
					tree[i][j].remove(0);
				}
				remainFoods[i][j] += food + transFood;
			}
		}
	}
	
	public static void fall() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int treeAge : tree[i][j]) {
					if (treeAge % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							
							if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
							tree[nx][ny].add(1);
						}
					}
				}
			}
		}
	}
	
	public static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				remainFoods[i][j] += foods[i][j];  
			}
		}
	}
	
	public static int checkLiveTrees() {
		int liveTree = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tree[i][j] != null) {
					liveTree += tree[i][j].size();	
				}
			}
		}
		return liveTree;
	}

}
