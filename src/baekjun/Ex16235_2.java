package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16235_2 {

	private static int n, m, k;
	private static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	private static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	private static int[][] foods, remainFoods;
	private static PriorityQueue<Integer>[][] tree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		foods = new int[n][n];
		remainFoods = new int[n][n];
		tree = new PriorityQueue[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				foods[i][j] = Integer.parseInt(st.nextToken());
				remainFoods[i][j] = 5;
				tree[i][j] = new PriorityQueue<>();
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			
			tree[x][y].offer(age);
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
				
				Queue<Integer> tempQueue = new LinkedList<>();
				while (!tree[i][j].isEmpty()) {
					int treeAge = tree[i][j].poll();
					
					if (food < treeAge) {
						transFood += treeAge / 2;
					} else {
						tempQueue.offer(treeAge + 1);
						food -= treeAge;
					}
				}
				
				while (!tempQueue.isEmpty()) {
					tree[i][j].offer(tempQueue.poll());
				}
				remainFoods[i][j] += food + transFood;
			}
		}
	}
	
	public static void fall() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Queue<Integer> tempQueue = new LinkedList<>();
				
				while (!tree[i][j].isEmpty()) {
					int treeAge = tree[i][j].poll();
					tempQueue.offer(treeAge);
					if (treeAge % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							
							if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
							tree[nx][ny].offer(1);
						}
					}
				}
				
				while (!tempQueue.isEmpty()) {
					tree[i][j].offer(tempQueue.poll());
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
				liveTree += tree[i][j].size();
			}
		}
		return liveTree;
	}
}
