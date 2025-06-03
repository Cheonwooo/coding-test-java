package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex9019 {
	
	private static class Command {
		int num;
		String cmd;

		public Command(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
		
		public int D() {
			return num * 2 % 10000;
		}
		
		public int S() {
			return num == 0 ? 9999 : num - 1;
		}
		
		public int L() {
			return num % 1000 * 10 + num / 1000;
		}
		
		public int R() {
			return num % 10 * 1000 + num / 10;
		}
	}
	
	private static int a, b;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			bfs();
		}
	}
	
	private static void bfs() {
		boolean[] visited = new boolean[10000];
		Queue<Command> q = new LinkedList<>();
		visited[a] = true;
		q.offer(new Command (a, ""));
		
		while (!q.isEmpty()) {
			Command cur = q.poll();
			
			if (cur.num == b) {
				System.out.println(cur.cmd);
				break;
			}
			
			if (!visited[cur.D()]) {
				q.offer(new Command(cur.D(), cur.cmd + "D"));
				visited[cur.D()] = true;
			}
			
			if (!visited[cur.S()]) {
				q.offer(new Command(cur.S(), cur.cmd + "S"));
				visited[cur.S()] = true;
			}
			
			if (!visited[cur.L()]) {
				q.offer(new Command(cur.L(), cur.cmd + "L"));
				visited[cur.L()] = true;
			}
			
			if (!visited[cur.R()]) {
				q.offer(new Command(cur.R(), cur.cmd + "R"));
				visited[cur.R()] = true;
			}
			
		}
	}
}
