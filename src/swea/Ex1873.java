package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1873 {
	private static int H, W, x, y, nowDirection;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static String[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new String[H][W];
			
			for (int i = 0 ; i < H; i++) {
				String[] maps = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					map[i][j] = maps[j];
					
					if (checkPosition(map[i][j])) {
						x = i;
						y = j;
						nowDirection = checkDirection(map[i][j]);
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String[] command = br.readLine().split("");
			
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < H; k++) {
					for (int j = 0; j < W; j++) {
						sb.append(map[k][j]);
					}
					sb.append("\n");
				}
				sb.append(nowDirection);
				sb.append("\n");
				checkCommand(command[i]);
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static boolean checkPosition(String position) {
		if (position.equals("^") || position.equals(">") || position.equals("v") || position.equals("<")) {
			return true;
		}
		return false;
	}
	
	public static int checkDirection(String position) {
		if (position.equals("^") || position.equals("U")) return 0;
		else if (position.equals(">") || position.equals("R")) return 1;
		else if (position.equals("v") || position.equals("D")) return 2;
		else return 3;
	}
	
	public static void checkCommand(String command) {
		if (command.equals("U") || command.equals("R") || command.equals("D") || command.equals("L")) {
			move(command);
		}
		else shotBomb();
	}
	
	public static void move(String command) {
		nowDirection = checkDirection(command);
		
		int nx = x + dx[nowDirection];
		int ny = y + dy[nowDirection];
		
		map[x][y] = makePosition(nowDirection);
		
		if (nx < 0 || nx >= H || ny < 0|| ny >= W) return;
		
		if (!map[nx][ny].equals(".")) return;
		
		//평지인 경우 이동
		map[x][y] = ".";
		map[nx][ny] = makePosition(nowDirection);
		x = nx;
		y = ny;
	}
	
	public static String makePosition(int direction) {
		if (direction == 0) return "^";
		else if (direction == 1) return ">";
		else if (direction == 2) return "v";
		else return "<";
	}
	
	public static void shotBomb() {
		int cx = x;
		int cy = y;
		while (true) {
			int nx = cx + dx[nowDirection];
			int ny = cy + dy[nowDirection];
			
			if (nx < 0 || nx >= H || ny < 0|| ny >= W || map[nx][ny].equals("#")) break;
			
			if (map[nx][ny].equals(".") || map[nx][ny].equals("-")) {
				cx = nx;
				cy = ny;
				continue;
			}
			
			if (map[nx][ny].equals("*")) {
				map[nx][ny] = ".";
				break;
			}
		}
	}

}
