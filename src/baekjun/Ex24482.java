package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex24482 {
	
	private static int[] answer;
	private static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		answer = new int[n+1];
		Arrays.fill(answer, -1);
		list = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 1; i < n+1; i++) {
			Collections.sort(list[i], Collections.reverseOrder());
		}
		
		dfs(r, 0);
		
		for (int i = 1; i < n+1; i++) {
			System.out.println(answer[i]);
		}
	}
	
	private static void dfs(int start, int d) {
		answer[start] = d;
		
		for (int next : list[start]) {
			if (answer[next] != -1) continue;
			dfs(next, d+1);
		}
	}

}
