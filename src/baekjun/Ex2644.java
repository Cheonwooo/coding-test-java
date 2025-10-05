package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex2644 {
	
	private static int answer = -1;
	private static boolean[] visited;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		list = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(x, y, 0);
		System.out.println(answer);
	}
	
	private static void dfs(int start, int end, int count) {
		if (start == end) {
			answer = count;
			return;
		}
		
		visited[start] = true;
		for (int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			if (!visited[next]) {
				dfs(next, end, count + 1);
			}
		}
	}

}
