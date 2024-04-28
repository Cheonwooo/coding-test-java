package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1210 {
	private static int[] dy = {-1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			sb.append("#").append(t).append(" ");
			
			int[][] ladders = new int[100][100];
			boolean[][] visited = new boolean[100][100];
			
			int startX = 0;
			int startY = 0;
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < 100; k++) {
					ladders[j][k] = Integer.parseInt(st.nextToken());
					
					if (ladders[j][k] == 2) {
						startX = j;
						startY = k;
					}
				}
			}
			visited[startX][startY] = true;
			startX--;//출발할 때 한칸 위로
			visited[startX][startY] = true;
			
			startY = traverseLadder(ladders, visited, startX, startY);
			
			sb.append(startY).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int traverseLadder(int[][] ladders, boolean[][] visited, int startX, int startY) {
		while (startX != 0) {
			boolean checkMove = false;
			
			for (int i = 0; i < 2; i++) {
				int ny = startY + dy[i];
				
				if (canMove(ny)) {
					if (!visited[startX][ny] && ladders[startX][ny] == 1) {
						visited[startX][ny] = true;
						checkMove = true;
						startY = ny;
						break;
					}
				}
			}
			if (!checkMove) {
				startX--;
				visited[startX][startY] = true;
			}
		}
		return startY;
	}
	
	public static boolean canMove(int ny) {
		return ny >=0 && ny < 100;
	}
}
