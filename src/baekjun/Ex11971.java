package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11971 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] limit = new int[101];
		int[] speed = new int[101];
		
		int start = 1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int dist = Integer.parseInt(st.nextToken()); 
			int limitSpeed = Integer.parseInt(st.nextToken());
			
			for (int j = start; j < start + dist; j++) {
				limit[j] = limitSpeed;
			}
			start += dist;
		}
		
		start = 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int dist = Integer.parseInt(st.nextToken()); 
			int limitSpeed = Integer.parseInt(st.nextToken());
			
			for (int j = start; j < start + dist; j++) {
				speed[j] = limitSpeed;
			}
			start += dist;
		}
		
		int max = 0;
		for (int i = 1 ; i <= 100; i++) {
			if (speed[i] > limit[i]) {
				max = Math.max(speed[i] - limit[i], max);
			}
		}
		System.out.println(max);
	}

}
