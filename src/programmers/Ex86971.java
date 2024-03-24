package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ex86971 {
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) {
		int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
		int answer = solution(9, wires);
		
		System.out.println(answer);
	}
	
	public static int solution(int n, int[][] wires) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
        	graph = new ArrayList<>();
        	
        	for (int j = 0; j < n+1; j++) {
            	graph.add(new ArrayList<>());
            }
        	
        	for (int j = 0; j < wires.length; j++) {
        		if (i == j) continue;
        		
        		int x = wires[j][0];
        		int y = wires[j][1];

        		graph.get(x).add(y);
        		graph.get(y).add(x);
        	}
        	int sub = Math.abs(calculateContactCount(n, wires[i][0]) - calculateContactCount(n, wires[i][1]));
        	min = Math.min(min, sub);
        }
        return min;
    }

	public static int calculateContactCount(int n, int start) {
		visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = true;
		
		int count = 1;
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				
				if (!visited[graph.get(now).get(i)]) {
					q.offer(graph.get(now).get(i));
					visited[graph.get(now).get(i)] = true;
					count++;
				}
			}
		}
		return count;
	}
	
}
