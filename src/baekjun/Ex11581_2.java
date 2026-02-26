package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11581_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[n+1][n+1];
		
		for (int i = 1; i < n; i++) {
			int count = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < count; j++) {
				int next = Integer.parseInt(st.nextToken());
				visited[i][next] = true;
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				for (int k = 1; k < n+1; k++) {
					if (visited[i][k] && visited[k][j]) {
						visited[i][j] = true;
					}
				}
			}
		}
		
		String answer = "NO CYCLE";
		
		for (int i = 1; i < n+1; i++) {
			if (visited[1][i] && visited[i][i]) {
				answer = "CYCLE";
				break;
			}
		}
		
		System.out.println(answer);
	}
}
