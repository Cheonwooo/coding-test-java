package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex3190 {
	public static class Dummy {
		int x;
		int y;
		
		public Dummy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean[][] apple;
	private static Deque<Dummy> dq = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[n][n];
		
		int k = Integer.parseInt(br.readLine());
		apple = new boolean[n][n];
		
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			apple[x][y] = true;
		}
		
		int l = Integer.parseInt(br.readLine());
		char[] direction = new char[10001];
		boolean[] checkCount = new boolean[10001];
		
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			
			checkCount[count] = true;
			direction[count] = dir;
		}
		
		int count = 0;
		int x = 0;
		int y = 0;
		int d = 1;
		map[x][y] = true;
		dq.addFirst(new Dummy(x, y));
		
		while (true) {
			count++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny]) break;
			
			dq.addFirst(new Dummy(nx ,ny));
			map[nx][ny] = true;
			
			if (isApple(nx, ny)) {
				apple[nx][ny] = false;
			} else {
				Dummy dummy = dq.pollLast();
				map[dummy.x][dummy.y] = false; 
			}
			
			x = nx;
			y = ny;
			
			if (checkCount[count]) {
				d = changeDirection(d, direction[count]);
			}
		}
		System.out.println(count);
	}
	
	public static boolean isApple(int x, int y) {
		return apple[x][y];
	}
	
	public static int changeDirection(int d, char direction) {
		if (direction == 'L') {
			d -= 1;
			if (d < 0) d = 3;
		} else {
			d +=1;
			if (d > 3) d = 0;
		}
		return d;
	}

}
