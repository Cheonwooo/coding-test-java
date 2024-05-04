package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2805 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = (int)s.charAt(j)-'0';
				}
			}
			
			int sum = 0;
			for (int i = 0; i < n/2; i++) {
				for (int j = n/2 - i; j <= n/2 + i; j++) {
					sum += arr[i][j] + arr[(n-1)-i][j];
				}
			}
			
			for (int i = 0; i < n; i++) {
				sum += arr[n/2][i];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
