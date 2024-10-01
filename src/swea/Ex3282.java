package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 21,248kb 시간 124ms

public class Ex3282 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[k+1];
			dp[0] = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				for (int j = k; j >= v; j--) {
					dp[j] = Math.max(dp[j], dp[j-v] + c);
				}
			}
			
			int answer = 0;
			for (int i = 0; i < k+1; i++) {
				answer = Math.max(answer, dp[i]);
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

}
