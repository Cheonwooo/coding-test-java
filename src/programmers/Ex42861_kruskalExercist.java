package programmers;

import java.util.Arrays;

/*
 * 크루스칼 알고리즘
 * 부모찾는 메서드
 * 합집합으로 만드는 메서드
 * 
 */

public class Ex42861_kruskalExercist {
	private static int[] parent = new int[101];

	public static void main(String[] args) {
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		int answer = 0;
		
		for (int i = 0 ; i < 101; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(costs, (o1, o2) -> (o1[2] - o2[2]));
		
		for (int i = 0; i < costs.length; i++) {
			if (findParent(costs[i][0]) != findParent(costs[i][1])) {
				unionParent(costs[i][0], costs[i][1]);
				answer += costs[i][2];
			}
		}
		
		System.out.println(answer);

	}
	
	public static int findParent(int x) {
		if (x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int x, int y) { 
		x = parent[x];
		y = parent[y];
		if (x != y) parent[y] = x;
	}
}
