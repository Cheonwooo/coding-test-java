package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex49191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        
        for (int i = 0; i < results.length; i++) {
        	graph[results[i][0]][results[i][1]] = 1;
        	graph[results[i][1]][results[i][0]] = -1;
        }
        
        for (int i = 1; i < n+1; i++) {
        	for (int j = 1; j < n+1; j++) {
        		for (int k = 1; k < n+1; k++) {
        			if (graph[i][k] == 1 && graph[k][j] == 1) {
        				graph[i][j] = 1;
        				graph[j][i] = -1;
        			}
        			
        			if (graph[i][k] == -1 && graph[k][j] == -1) {
        				graph[i][j] = -1;
        				graph[j][i] = 1;
        			}
        		}
        	}
        }
        
        for (int i = 1; i < n+1; i++) {
        	int count = 0;
        	for (int j = 1; j < n+1; j++) {
        		if (graph[i][j] == 1 || graph[i][j] == -1) {
        			count++;
        		}
        	}
        	if (count == n-1) answer++;
        }
        
        return answer;
    }
}
