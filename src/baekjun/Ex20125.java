package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex20125 {
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int hx = 0;
		int hy = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
					if (arr[nx][ny] == '*') count++;
				}
				
				if (count == 4) {
					hx = i;
					hy = j;
					break;
				}
			}
			if (hx != 0 && hy != 0) break;
		}
		StringBuilder sb = new StringBuilder();
		sb.append((hx+1) + " " + (hy+1) + "\n");
		//¿ÞÆÈ
		int count = 0;
		int ny = hy-1;
		while (ny >= 0 && arr[hx][ny] != '_') {
			ny--;
			count++;
		}
		sb.append(count + " ");

		//¿À¸¥ÆÈ
		count = 0;
		ny = hy+1;
		while (ny < n && arr[hx][ny] != '_') {
			ny++;
			count++;
		}
		sb.append(count + " ");
		
		//Çã¸®
		count = 0;
		int nx = hx+1;
		while (arr[nx][hy] != '_') {
			nx++;
			count++;
		}
		sb.append(count + " ");
		
		//¿Þ´Ù¸®
		count = 0;
		int cx = nx;
		while (cx < n && arr[cx][hy-1] != '_') {
			cx++;
			count++;
		}
		sb.append(count + " ");
		
		//¿À¸¥´Ù¸®
		count = 0;
		cx = nx;
		while (cx < n && arr[cx][hy+1] != '_') {
			cx++;
			count++;
		}
		sb.append(count + " ");
		System.out.println(sb);
	}
}
