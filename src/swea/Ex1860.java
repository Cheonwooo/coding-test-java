package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1860 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			boolean[] customer = new boolean[11112];
			int[] fishBread = new int[11112];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				customer[Integer.parseInt(st.nextToken())] = true;
			}
			
			String answer = "Possible";
			if (customer[0]) {
				fishBread[0] = -1;
			}
			
			for (int i = 1; i <= 11_111; i++) {
				if (i % m == 0) {
					fishBread[i] += fishBread[i-1] + k;
				} else {
					fishBread[i] += fishBread[i-1];
				}
				
				if (customer[i]) {
					fishBread[i] -=1;
				}
			}
			
			for (int i = 0; i <= 11_111; i++) {
				if (fishBread[i] < 0) {
					answer = "Impossible";
					break;
				}
			}
				
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
