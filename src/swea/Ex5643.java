package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5643 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] result = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int lose = Integer.parseInt(st.nextToken());
				int win = Integer.parseInt(st.nextToken());
				
				result[lose][win] = 1;
				result[win][lose] = -1;
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= N; k++) {
						if (result[i][k] == 1 && result[k][j] == 1) {
							result[i][j] = 1;
							result[j][i] = -1;
						}
						
						if (result[i][k] == -1 && result[k][j] == -1) {
							result[i][j] = -1;
							result[j][i] = 1;
						}
					}
				}
			}
			
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				int count = 0;
				for (int j = 1; j <= N; j++) {
					if (result[i][j] != 0) {
						count++;
					}
				}
				if (count == N-1) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
