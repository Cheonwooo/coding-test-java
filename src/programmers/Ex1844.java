package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Ex1844 {
	private static int n, m;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        answer = bfs(maps, 0, 0);
        
        
        if (answer == 1) {
        	System.out.println(-1);
        } else {
        	System.out.println(answer);
        }
        return answer;
    }
	
	public int bfs(int[][] maps, int x, int y) {
		q.offer(new Pair(x, y));
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			
			x = pair.x;
			y = pair.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if (maps[nx][ny] == 0) {
					continue;
				}
				
				if (maps[nx][ny] == 1) {
					maps[nx][ny] = maps[x][y] + 1;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		return maps[n-1][m-1];
	}

}
