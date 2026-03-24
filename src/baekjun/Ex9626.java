package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex9626 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[m + u + d][n + l + r];
		
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[u + i][l + j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != '\0') {
					sb.append(arr[i][j]);
				} else if (i % 2 == 0){
					if (j % 2 == 0) {
						sb.append("#");
					} else {
						sb.append(".");
					}
				} else {
					if (j % 2 == 0) {
						sb.append(".");
					} else {
						sb.append("#");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
