package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16928 {
	
	private static int n, m;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[107];
		
		for (int i = 0; i < n+m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			arr[pre] = next;
		}
		
		bfs(1);
	}
	
	private static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[107];
		q.offer(new int[] {start, 0});
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			int now = cur[0];
			int count = cur[1];
			
			if (now == 100) {
				System.out.println(count);
				return;
			}
			
			for (int i = 1; i <= 6; i++) {
				int next = now + i;
				if (arr[next] != 0) {
					next = arr[next];
				}
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new int[] {next, count+1});
				}
			}
		}
	}
}
