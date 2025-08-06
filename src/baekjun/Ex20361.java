package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20361 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] ball = new boolean[n+1];
		ball[x] = true;
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			boolean temp = ball[a];
			ball[a] = ball[b];
			ball[b] = temp;
		}
		
		for (int i = 1; i < n+1; i++) {
			if (ball[i]) {
				System.out.println(i);
				return;
			}
		}
	}
}
