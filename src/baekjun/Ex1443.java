package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1443 {
	
	private static int d, p, answer = -1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		dfs(1, 0, 9);
		System.out.println(answer);
	}
	
	private static void dfs(int sum, int count, int start) {
		if ((sum + "").length() > d) {
			return;
		}
		
		if (count == p) {
			answer = Math.max(answer, sum);
		}
		
		for (int i = start; i >= 2; i--) {
			dfs(sum * i, count + 1, i);
		}
	}

}
