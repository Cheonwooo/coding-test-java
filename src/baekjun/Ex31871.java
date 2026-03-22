package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex31871 {
	private static int n, m;
	private static long max = -1;
	private static int[] temp;
	private static boolean[] visited;
	private static int[][] d;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		d = new int[n+1][n+1];
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			d[u][v] = Math.max(d[u][v], time);
		}
		
		temp = new int[n+2];
		visited = new boolean[n+1];
		makeSeq(1);
		System.out.println(max);
	}
	
	private static void makeSeq(int depth) {
		if (depth == n+1) {
			long totalTime = calculateTotalTime();
			if (totalTime != -1) {
				max = Math.max(totalTime, max);
			}
			return;
		}
		
		for (int i = 1; i < n+1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				makeSeq(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	private static long calculateTotalTime() {
		long sum = 0;
		int pre = temp[0];
		for (int i = 1; i < n+2; i++) {
			int next = temp[i];
			if (d[pre][next] != 0) {
				sum += d[pre][next];
				pre = next;
			} else {
				return -1;
			}
		}
		return sum;
	}
}
