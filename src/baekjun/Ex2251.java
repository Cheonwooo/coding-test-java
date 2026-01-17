package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ex2251 {
	
	private static int A, B, C;
	private static boolean[][][] visited = new boolean[201][201][201];
	private static Set<Integer> answer = new TreeSet<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		bfs(0, 0, C);
		
		for (int number : answer) {
			System.out.print(number + " ");
		}
	}
	
	private static void bfs(int a, int b, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {a, b, c});
		
		while (!q.isEmpty()) { 
			int[] cur = q.poll();
			
			a = cur[0];
			b = cur[1];
			c = cur[2];
			
			if (visited[a][b][c]) continue;
			visited[a][b][c] = true;
			
			if (a == 0) {
				answer.add(c);
			}
			
			if (a + b > B) {
				q.offer(new int[] {a - (B - b), B, c});
			} else {
				q.offer(new int[] {0, (a + b), c});
			}
			
			if (a + c > C) {
				q.offer(new int[] {a - (C - c), b, C});
			} else {
				q.offer(new int[] {0, b, (a + c)});
			}
			
			if (b + a > A) {
				q.offer(new int [] {A, b - (A - a), c});
			} else {
				q.offer(new int[] {(b + a), 0, c});
			}
			
			if (b + c > C) {
				q.offer(new int[] {a, b - (C - c), c});
			} else {
				q.offer(new int[] {a, 0, (b + c)});
			}
			
			if (c + a > A) {
				q.offer(new int[] {A, b, c - (A - a)});
			} else {
				q.offer(new int[] {(c + a), b, 0});
			}
			
			if (c + b > B) {
				q.offer(new int[] {a, B, c- (B - b)});
			} else {
				q.offer(new int[] {a, (c + b), 0});
			}
		}
	}

}
