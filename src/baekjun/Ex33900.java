package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex33900 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		int[][] camp = new int[r][c];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				camp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for (int i = 0; i <= n - r; i++) {
			for (int j = 0; j <= m - c; j++) {
				
				int[] temp = new int[r*c];
				int index = 0;
				for (int k = 0; k < r; k++) {
					for (int l = 0; l < c; l++) {
						temp[index++] = arr[i+k][j+l] - camp[k][l];
					}
				}
				
				boolean check = false;
				for (int k = 0; k < temp.length-1; k++) {
					if (temp[k] != temp[k+1]) {
						check = true;
						break;
					}
				}
				
				if (!check) answer++;
			}
		}
		System.out.println(answer);
	}

}
