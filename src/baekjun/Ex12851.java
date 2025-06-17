package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex12851 {
	
	private static int n, k, count, answer = 100_000_000;
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[100001];
		
		if (n >= k) {
			System.out.println(n - k);
			System.out.println(1);
		} else {
			bfs();
			System.out.println(answer);
			System.out.println(count);
		}
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		arr[n] = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (answer < arr[cur]) return;
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				if (i == 0) {
					next = cur - 1;
				} else if (i == 1) { 
					next = cur + 1;
				} else {
					next = cur * 2;
				}
				
				if (next == k) {
					answer = arr[cur];
					count++;
				}
				
				if (next >= 0 && next < arr.length && (arr[next] == 0 || (arr[next] == arr[cur] + 1))) {
					q.offer(next);
					arr[next] = arr[cur] + 1;
				}
			}
		}
	}
}
