package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex13913 {
	
	private static int n, k;
	private static int[] time, route;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		route = new int[100001];
	
		bfs();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(k);
		int index = k;
		
		while (index != n) {
			stack.push(route[index]);
			index = route[index];
		}
		
		System.out.println(time[k]);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		time[n] = 0;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (now == k) return;
			
			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0) next = now -1;
				else if (i == 1) next = now + 1;
				else next = now * 2;
				
				if (next > 100_000 || next < 0) continue;
				
				if (time[next] == 0) {
					q.offer(next);
					time[next] = time[now] + 1;
					route[next] = now;
				}
				
			}
		}
	}
}	
