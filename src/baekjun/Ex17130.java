package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex17130 {
	
	private static int n, m;
	private static int[] dx = {-1, 0, 1};
	private static int[] dy = {1, 1, 1};
	private static int[][] dp;
	private static char[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int sx = 0;
		int sy = 0;
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.charAt(j);
				if (arr[i][j] == 'R') {
					sx = i;
					sy = j;
				}
			}
		}
		
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[sx][sy] = 0;
//		for (int i = 0; i < n; i++) {
//			if (arr[i][0] == '.' || arr[i][0] == 'C') {
//				dp[i][0] = 0;
//			}
//		}
		
		calculateCarrot();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		int answer = escape();
		System.out.println(answer);
	}

	private static void calculateCarrot() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[j][i] == -1) continue;
				for (int k = 0; k < 3; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == '#') continue;
					
					int next = dp[j][i];
					if (arr[nx][ny] == 'C') next++;
					dp[nx][ny] = Math.max(dp[nx][ny], next);
				}
			}
		}
	}

	private static int escape() {
		int answer = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (arr[i][j] == 'O') {
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		return answer;
	}
}
