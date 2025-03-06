package programmers;

class Ex72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] graph = new int[n+1][n+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == j) continue;
                graph[i][j] = 100_000_001;
            }
        }
        
        for (int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int dis = fares[i][2];
            
            graph[x][y] = dis;
            graph[y][x] = dis;
        }
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n+1; i++) {
                answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        
        return answer;
    }
}
