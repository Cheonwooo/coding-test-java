package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2606 {
	
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
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		System.out.println(bfs(1));
	}

	public static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.offer(start);
		visited[start] = true;
		
		int answer = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < list[now].size(); i++) {
				if (!visited[list[now].get(i)]) {
					visited[list[now].get(i)] = true;
					answer++;
					q.offer(list[now].get(i));
				}
			}
		}
		
		return answer;
	}
}
