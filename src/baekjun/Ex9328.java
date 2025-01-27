package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex9328 {
	
	private static int x, y, answer;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static boolean isFind;
	private static boolean[] key;//가지고 있는 키
	private static boolean[][] visited;
	private static char[][] map;
	private static List<int[]> entrances;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map = new char[x][y];
			key = new boolean[26];
			
			for (int i = 0; i < x; i++) {
				String[] input = br.readLine().split("");
				for (int j = 0; j < y; j++) {
					map[i][j] = input[j].charAt(0);
				}
			}
			
			String str = br.readLine();
			if (!str.equals("0")) {
				String[] keys = str.split("");
				for (String value : keys) {
					key[value.charAt(0)-'a'] = true;
				}
			}
			
			answer = 0;
			entrances = new ArrayList<>();
			findKey();
			findEntrance();
			
			isFind = true;
			while (true) {
				if (!isFind) break;
				isFind = false;
				
				visited = new boolean[x][y];
				for (int i = 0 ; i < y; i++) {
					if (!visited[0][i] && isEntrance(0, i)) {
						bfs(0, i);
					}
					if (!visited[x-1][i] && isEntrance(x-1, i)) {
						bfs(x-1, i);
					}
				}
				for (int i = 1; i < x-1; i++) {
					if (!visited[i][0] && isEntrance(i, 0)) {
						bfs(i, 0);
					}
					if (!visited[i][y-1] && isEntrance(i, y-1)) {
						bfs(i, y-1);
					} 
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
	
	public static void findKey() {
		for (int i = 0; i < y; i++) {
			if (Character.isLowerCase(map[0][i])) {
				key[map[0][i] - 'a'] = true;
				map[0][i] = '.';
			}
			if (Character.isLowerCase(map[x-1][i])) {
				key[map[x-1][i] - 'a'] = true;
				map[x-1][i] = '.';
			}
		}
		
		for (int i = 1; i < x-1; i++) {
			if (Character.isLowerCase(map[i][0])) {
				key[map[i][0] - 'a'] = true;
				map[i][0] = '.';
			}
			if (Character.isLowerCase(map[i][y-1])) {
				key[map[i][y-1] - 'a'] = true;
				map[i][y-1] = '.';
			}
		}
	}
	
	public static void findEntrance() {
		for (int i = 0; i < y; i++) {
			if (map[0][i] == '.') {
				entrances.add(new int[] {0, i});
			} else if (map[0][i] != '*') {
				if (map[0][i] == '$') {
					map[0][i] = '.';
					answer++;
					entrances.add(new int[] {0, i});
				} else {
					if(Character.isUpperCase(map[0][i]) && key[Character.toLowerCase(map[0][i]) - 'a']) {
						entrances.add(new int[] {0,i});
						map[0][i] = '.';
					}
				}
			}
			
			if (map[x-1][i] == '.') {
				entrances.add(new int[] {x-1, i});
			} else if (map[x-1][i] != '*') {
				if (map[x-1][i] == '$') {
					map[x-1][i] = '.';
					answer++;
					entrances.add(new int[] {x-1, i});
				} else {
					if(Character.isUpperCase(map[x-1][i]) && key[Character.toLowerCase(map[x-1][i]) - 'a']) {
						entrances.add(new int[] {x-1,i});
						map[x-1][i] = '.';
					}
				}
			}
		}
		
		for (int i = 1; i < x-1; i++) {
			if (map[i][0] == '.') {
				entrances.add(new int[] {i, 0});
			} else if (map[i][0] != '*') {
				if (map[i][0] == '$') {
					map[i][0] = '.';
					answer++;
					entrances.add(new int[] {i, 0});
				} else {
					if(Character.isUpperCase(map[i][0]) && key[Character.toLowerCase(map[i][0]) - 'a']) {
						entrances.add(new int[] {i,0});
						map[i][0] = '.';
					}
				}
			}
			
			if (map[i][y-1] == '.') {
				entrances.add(new int[] {i, y-1});
			} else if (map[i][y-1] != '*') {
				if (map[i][y-1] == '$') {
					map[i][y-1] = '.';
					answer++;
					entrances.add(new int[] {i, y-1});
				} else {
					if(Character.isUpperCase(map[i][y-1]) && key[Character.toLowerCase(map[i][y-1]) - 'a']) {
						entrances.add(new int[] {i,y-1});
						map[i][y-1] = '.';
					}
				}
			}
		}
	}
	
	public static boolean isEntrance(int a, int b) {
		for (int[] val : entrances) {
			if (val[0] == a && val[1] == b) return true;
		}
		if (Character.isUpperCase(map[a][b])) {
			if (key[Character.toLowerCase(map[a][b])-'a']) {
				map[a][b] = '.';
				return true;
			}
		}
		return false;
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		visited[a][b] = true;
		q.offer(new int[] {a, b});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int cx = cur[0];
			int cy = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if (nx < 0 || nx >= x || ny < 0 || ny >= y || visited[nx][ny]) continue;
				if (map[nx][ny] == '*') continue;
				if (map[nx][ny] == '$') {//문서를 발견했을 때
					map[nx][ny] = '.';
					answer++;
					isFind = true;
				} else if (Character.isUpperCase(map[nx][ny])){//문을 발견했을 때
					if (key[Character.toLowerCase(map[nx][ny]) - 'a']) {//키를 가지고 있다면
						map[nx][ny] = '.';
					} else { 
						visited[nx][ny] = true;
						continue;
					}
				} else if (Character.isLowerCase(map[nx][ny])){//키를 찾았을 때
					key[map[nx][ny]-'a'] = true;
					map[nx][ny] = '.';
					isFind = true;
				}
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}

}
