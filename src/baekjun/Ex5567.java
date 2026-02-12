package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex5567 {

	private static int n;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		list = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		System.out.println(findFriends(1));
	}
	
	private static int findFriends(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		q.offer(new int[] {start, 1});
		visited[start] = true;
		
		int count = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int depth = cur[1];
			if (depth > 2) continue;
			
			for (int i = 0; i < list[cur[0]].size(); i++) {
				int next = list[cur[0]].get(i);
				if (!visited[next]) {
					visited[next] = true;
					count++;
					q.offer(new int[] {next, depth + 1});
				}
			}
		}
		return count;
	}

}
