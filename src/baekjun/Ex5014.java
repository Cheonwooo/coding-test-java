package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex5014 {
	
	private static int f, u, d, answer = -1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		bfs(s, g, 0);
		if (answer != -1) {
			System.out.println(answer);
		} else {
			System.out.println("use the stairs");
		}
	}

	private static void bfs(int s, int e, int count) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {s, count});
		boolean[] visited = new boolean[f+1];
		visited[s] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			int cx = now[0];
			int cnt = now[1];
			
			if (cx == e) {
				answer = cnt;
				return;
			}
			
			//위
			int nu = cx + u;
			if (nu <= f && !visited[nu]) {
				visited[nu] = true;
				q.offer(new int[] {nu, cnt+1});
			}
			//아래
			int nd = cx - d;
			if (nd >= 1 && !visited[nd]) {
				visited[nd] = true;
				q.offer(new int[] {nd, cnt+1});
			}
		}
	}
}
