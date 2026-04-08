package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex23301 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[] time = new int[1001];
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				for (int p = s+1; p <= e; p++) {
					time[p]++;
				}
			}
		}
		
		int answerS = 0;
		int answerE = t;
		int max = 0;
		int s = 1;
		int sum = 0;
		for (int i = 0; i <= t; i++) {
			sum += time[i];
		}
		max = sum;
		
		//0 4/1 5/2 6
		for (int i = t+1; i <= 1000; i++) {
			sum -= time[s];
			sum += time[i];
			s++;

			if (max < sum) {
				answerS = s-1;
				answerE = i;
				max = sum;
			} 
		}
		
		System.out.println(answerS + " " + answerE);
	}

}
