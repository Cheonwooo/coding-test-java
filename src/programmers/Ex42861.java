package programmers;

import java.util.Arrays;

/*
 * 아이디어
 * 크루스칼 알고리즘
 */

public class Ex42861 {
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		
		System.out.println(solution(n, costs));
	}
	private static int[] parent = new int[101];
	
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        
        for (int i = 1; i < parent.length; i++) {
        	parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> (o1[2] - o2[2]));
        
        for (int i = 0; i < costs.length; i++) {
        	if (findParent(costs[i][0]) != findParent(costs[i][1])) {
        		unionParent(costs[i][0], costs[i][1]);
        		answer += costs[i][2];
        	}
        }
        return answer;
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
