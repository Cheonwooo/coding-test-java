package programmers;

import java.util.*;

class Ex1843 {
    
    private static int size;
    private static int[][] dp;
    private static boolean[] plus;
    public int solution(String arr[]) {
        
        size = arr.length/2+1;
        dp = new int[size][size];
        plus = new boolean[size];
        plus[0] = true;
        
        for (int i = 0; i < size-1; i++) {
            if (arr[i*2+1].equals("+")) {
                plus[i+1] = true;
            }
        }
        
        for (int i = 0; i < size; i++) {
            if (plus[i]) {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
            } else {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            
            dp[i][i] = Integer.parseInt(arr[i*2]);
        }
        
        dfs(0, size-1);
        int answer = dp[0][size-1];
        return answer;
    }
    
    public static int dfs(int start, int end) {
        if (dp[start][end] > Integer.MIN_VALUE 
            && dp[start][end] < Integer.MAX_VALUE) return dp[start][end];
        
        if (plus[start]) {//+¸é ÃÖ´ñ°ª
            for (int i = start; i < end; i++) {
                dp[start][end] = Math.max(dp[start][end], plus[i+1] ? dfs(start, i) + dfs(i+1, end) : dfs(start, i) - dfs(i+1, end));
            }
        } else {//-¸é ÃÖ¼Ú°ª
            for (int i = start; i < end; i++) {
                dp[start][end] = Math.min(dp[start][end], plus[i+1] ? dfs(start, i) + dfs(i+1, end) : dfs(start, i) - dfs(i+1, end));
            }
        }
        return dp[start][end];
    }
}