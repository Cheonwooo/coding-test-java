package programmers;

class Ex92343 {
    
    private int max;
    private int[] cinfo;
    private int[][] cedges;
    
    public int solution(int[] info, int[][] edges) {
        cinfo = info;
        cedges = edges;
        
        boolean[] visited = new boolean[info.length];
        dfs(0, visited, 0, 0);
        
        return max;
    }
    
    private void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[idx] = true;
        if (cinfo[idx] == 0) {//양이라면
            sheepCnt++;
            max = Math.max(max, sheepCnt);
        } else {
            wolfCnt++;
        }
        
        if (sheepCnt <= wolfCnt) return;
        
        for (int i = 0; i < cedges.length; i++) {
            if (visited[cedges[i][0]] && !visited[cedges[i][1]]) {
                boolean[] tempVisited = new boolean[cinfo.length];
                for (int j = 0; j < visited.length; j++) {
                    tempVisited[j] = visited[j];
                }
                dfs(cedges[i][1], tempVisited, sheepCnt, wolfCnt);
            }
        }
    }
}
