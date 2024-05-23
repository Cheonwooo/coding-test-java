package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14499 {
	private static int n, m, x, y;
	private static int[][] map, arr = new int[4][3];
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] command = new int[k];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			command[i] = Integer.parseInt(st.nextToken());
			move(command[i]-1);
			
		}
	}
	
	public static void move(int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if (nx < 0 || nx >= n || ny < 0 || ny >= m) return;
		
		x = nx;
		y = ny;
		
		roll(d);
		
		if (map[nx][ny] == 0) {
			map[nx][ny] = arr[3][1];
		} else {
			arr[3][1] = map[nx][ny];
			map[nx][ny] = 0;
		}
		System.out.println(arr[1][1]);
	}
	
	public static void roll(int d) {
		int temp = arr[3][1];
		if (d == 2) {
			 arr[3][1] = arr[0][1];
			 arr[0][1] = arr[1][1];
			 arr[1][1] = arr[2][1];
			 arr[2][1] = temp;
		} else if (d == 0) {
			arr[3][1] = arr[1][2];
			arr[1][2] = arr[1][1];
			arr[1][1] = arr[1][0];
			arr[1][0] = temp;
		} else if (d == 3) {
			arr[3][1] = arr[2][1];
			arr[2][1] = arr[1][1];
			arr[1][1] = arr[0][1];
			arr[0][1] = temp;
		} else {
			arr[3][1] = arr[1][0];
			arr[1][0] = arr[1][1];
			arr[1][1] = arr[1][2];
			arr[1][2] = temp;
		}
	}

}
