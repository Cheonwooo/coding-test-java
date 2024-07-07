package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1486_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = Integer.MAX_VALUE;
			int totalSubSet = 1 << n;
			
			for (int i = 0; i < totalSubSet; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) != 0) {
						sum += arr[j];
					}
				}
				if (sum >= b) {
					answer = Math.min(answer, sum);
				}
			}
			sb.append(answer-b).append("\n");
		}
		System.out.println(sb);
	}

}
