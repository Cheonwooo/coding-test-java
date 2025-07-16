package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex10994 {

	private static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int len = 4 * (n - 1) + 1;
		map = new char[len][len];
		for (int i = 0; i < len; i++) {
			Arrays.fill(map[i], ' ');
		}
		makeStars(0, n);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void makeStars(int r, int n) {
		if (n == 0) return;
		
		int x = 2 * r;
		int y = 2 * r;
		int len = 4 * (n - 1) + 1;
		
		for (int i = x; i < x + len; i++) {
			map[x][i] = '*';
			map[i][y] = '*';
			map[x+len-1][i] = '*';
			map[i][y+len-1] = '*';
		}
		makeStars(r+1, n-1);
	}
}

//1 - 1
//2 - 5
//3 - 9
//4 - 13
//4 *(n-1) + 1
//(2n,2n)