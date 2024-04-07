package programmers;

import java.util.ArrayList;

public class Ex43162 {
	private static int count;
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> networks = new ArrayList<>();

	public static void main(String[] args) {
		
		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
		
		System.out.println(solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {

		for (int i = 0; i < n; i++) {
        	networks.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (computers[i][j] == 1) {
        			networks.get(i).add(j);
        		}
        	}
        }
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
        	System.out.println(i);
        	bfs(i);
        }
        
        return count;
    }
	
	public static void bfs(int x) {
		if (!visited[x]) {
			visited[x] = true;
			count++;
		}
		
		for (int j = 0; j < networks.get(x).size(); j++) {
			int y = networks.get(x).get(j);
			
			if (!visited[y]) {
				visited[y] = true;
				bfs(y);
			}
		}
	}
}

