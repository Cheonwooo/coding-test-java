package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex21735 {
	
	private static int n, m, answer = 0;;
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 1, 0);
		System.out.println(answer);
	}

	private static void dfs(int pos, int size, int time) {
		if ((pos == n && time <= m) || (pos <= n && time >= m)) {
			answer = Math.max(size, answer);
			return;
		}
		
		dfs(pos + 1, size + arr[pos+1], time + 1);
		if (pos < n-1) {
			dfs(pos + 2, (size/2) + arr[pos+2], time + 1);
		}
	}
}
