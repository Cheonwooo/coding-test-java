package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex15684 {
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int n, m, h, a, b, answer = -1;
	private static boolean[][] ladder;
	private static List<Pair> pairs;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ladder = new boolean[m+1][n+2];
		
		if (h == 0) {
			answer = 0;
		} else {
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				ladder[a][b] = true;
			}
			
			pairs = new ArrayList<>();
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= n; j++) {
					if (ladder[i][j] || ladder[i][j-1] || ladder[i][j+1]) continue;
					pairs.add(new Pair(i, j));
				}
			}
			
			for (int i = 0; i <= 3; i++) {
				dfs(0, i, 0);
				if (answer != -1) break;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int depth, int count, int start) {
		if (depth == count) {
			if(addLadders()) {
				answer = count;
			}
			return;
		}
		
		for (int i = start; i < pairs.size(); i++) {
			Pair pair = pairs.get(i);
			
			if (ladder[pair.x][pair.y-1] || ladder[pair.x][pair.y] || ladder[pair.x][pair.y+1]) continue;
			ladder[pair.x][pair.y] = true;
			dfs(depth + 1, count, i + 1);
			ladder[pair.x][pair.y] = false; 
		}
	}
	
	public static boolean addLadders() {
		for (int i = 1; i <= n; i++) {
			if(!move(ladder, i)) return false;
		}
		return true;
	}
	
	public static boolean move(boolean[][] copyLadder, int ladderNumber) {
		int x = 1;
		int y = ladderNumber;
		
		while(x != m+1) {
			if (y == 1) {
				if (copyLadder[x][y]) y++;
			} else if (y == n) {
				if (copyLadder[x][y-1]) y--;
			} else {
				if (copyLadder[x][y]) y++;
				else if (copyLadder[x][y-1]) y--;
			}
			x++;
		}
		if (y == ladderNumber) return true;
		return false;
	}

}

