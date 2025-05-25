package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11659 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] sum = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		sum[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i < n+1; i++) {
			sum[i] += sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			System.out.println(sum[next] - sum[pre-1]);
			
		}
	}
}
