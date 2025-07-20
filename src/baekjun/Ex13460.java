package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex13460 {
	
	private static class Bead {
		int redx;
		int redy;
		int bluex;
		int bluey;
		int count;

		public Bead(int redx, int redy, int bluex, int bluey, int count) {
			this.redx = redx;
			this.redy = redy;
			this.bluex = bluex;
			this.bluey = bluey;
			this.count = count;
		}
	}
	
	private static int n, m, rx, ry, bx, by, hx, hy, answer = Integer.MAX_VALUE;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				} else if (map[i][j] == 'O') {
					hx = i;
					hy = j;
				}
			}
		}
		
		move();
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}
	
	private static void move() {
		//동서남북 돌기
		//벽에 맞을 때까지
		//벽에 맞았다면 왔던 방향 제외하고 탐색 visited
		Queue<Bead> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[n][m][n][m];
		q.offer(new Bead(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = true;
		
		while (!q.isEmpty()) {
			Bead cur = q.poll();
			int count = cur.count;
			
			if (count >= 10) {
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int crx = cur.redx;
				int cry = cur.redy;
				int cbx = cur.bluex;
				int cby = cur.bluey;
				
				//벽을 만나기 전까지 빨간 구슬 움직이기
				while (map[crx + dx[i]][cry + dy[i]] != '#') {
					crx += dx[i];
					cry += dy[i];
					if (map[crx][cry] == 'O') break;
				}
				
				while (map[cbx + dx[i]][cby + dy[i]] != '#') {
					cbx += dx[i];
					cby += dy[i];
					if (map[cbx][cby] == 'O') break;
				}
				
				if (map[cbx][cby] == 'O') continue;
				
				if (map[crx][cry] == 'O') {
					answer = Math.min(answer, count+1);
					return;
				}
				
				if (crx == cbx && cry == cby && map[crx][cry] != 'O') {
					int redLen = Math.abs(crx - cur.redx) + Math.abs(cry - cur.redy);
					int blueLen = Math.abs(cbx - cur.bluex)+ Math.abs(cby - cur.bluey);
					
					if (redLen > blueLen) {//파랑이 더 빨리 도착한 경우
						crx -= dx[i];
						cry -= dy[i];
					} else {
						cbx -= dx[i];
						cby -= dy[i];
					}
				}
				
				if (!visited[crx][cry][cbx][cby]) {
					visited[crx][cry][cbx][cby] = true;
					q.offer(new Bead(crx, cry, cbx, cby, count+1));
				}
			}
		}
	}
}
