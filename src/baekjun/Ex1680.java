package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1680 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[][] info = new int[n][2];
			
			int limit = 0;
			int answer = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int xi = Integer.parseInt(st.nextToken());
				int wi = Integer.parseInt(st.nextToken());
				
				info[i][0] = xi;
				info[i][1] = wi;
			}
			
			for (int i = 0; i < n; i++) {
				int xi = info[i][0];
				int wi = info[i][1];
				
				int sum = limit + wi;
				if (sum < w) {
					limit += wi;
					if (i == n-1) {
						answer += xi * 2;
					}
				} else if (sum > w){
					answer += xi * 2;
					limit = 0;
					i--;
				} else {
					answer += xi * 2;
					limit = 0;
				}
			}
			System.out.println(answer);
		}
	}
}
