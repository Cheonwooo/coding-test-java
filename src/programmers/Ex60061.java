package programmers;

import java.util.*;

class Ex60061 {
    
	private static int count = 0;
    private static boolean[][] pilar, bar;
    
//    public static void main(String[] args) {
//    	int n = 5;
//    	int[][] arr = {{1, 0, 0, 1}, {2, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 0, 0}};
//    	solution(n, arr);
//    }
    
    public static int[][] solution(int n, int[][] build_frame) {
        pilar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];
        
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            
            if (b == 1) {
                build(x, y, a, n);
            } else {
                destroy(x, y, a, n);
            }
        }
        
        int[][] answer = findArchitectures(n);
//        for (int i = 0; i <answer.length; i++) {
//        	System.out.println(i);
//        	for (int j = 0; j < answer[i].length; j++) {
//        		System.out.print(answer[i][j] + " " );
//        	}
//        	System.out.println();
//        }
        return answer;
    }
    
    public static void build(int x, int y, int a, int n) {
        if (a == 0) {
            if (canSurvivePilar(x, y)) {
                pilar[x][y] = true;
                count++;
            }
        } else {
            if (canSurviveBar(x, y)) {
                bar[x][y] = true;
                count++;
            }
        }
    }
    
    public static void destroy(int x, int y, int a, int n) {
    	if (a == 0) {
    		pilar[x][y] = false;
    		if(!canDelete(n)) pilar[x][y] = true;
            else count--;
    	} else {
    		bar[x][y] = false;
    		if(!canDelete(n)) bar[x][y] = true;
            else count--;
    	}
    }
    
    public static boolean canSurvivePilar(int x, int y) {
    	if (y == 0) return true;
    	if (pilar[x][y-1]) return true;
    	if (x != 0 && bar[x-1][y] || bar[x][y]) return true;
    	return false;
    }
    
    public static boolean canSurviveBar(int x, int y) {
    	if (y != 0 && pilar[x][y-1] || pilar[x+1][y-1]) return true;
    	if (x != 0 && bar[x-1][y] && bar[x+1][y]) return true;
    	return false;
    }
    
    public static boolean canDelete(int n) {    
        for(int i = 0; i <= n; i++) { 
            for(int j = 0; j <= n; j++) { 
                if(pilar[i][j] && canSurvivePilar(i, j) == false)  return false; // 기둥이 해당 위치에 있을 수 없다면 false 
                else if(bar[i][j] && canSurviveBar(i, j) == false) return false; // 바닥이 해당 위치에 있을 수 없다면 false 
            }
        }
        return true;
    }
    
    public static int[][] findArchitectures(int n) {
    	int[][] answer = new int[count][3];
        
    	int index = 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (pilar[i][j]) {
                	answer[index][0] = i;
                	answer[index][1] = j;
                	answer[index++][2] = 0;
                }
                if (bar[i][j]) {
                	answer[index][0] = i;
                	answer[index][1] = j;
                	answer[index++][2] = 1;
                }
            }
        }
        return answer;
    }
}