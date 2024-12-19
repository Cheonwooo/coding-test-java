package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 19992kb, 시간 232ms

public class Ex1516 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n+1];
		int[] inDegree = new int[n+1];
		int[] dp = new int[n+1];
		List<Integer>[] list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int takeTime = Integer.parseInt(st.nextToken());
			time[i] = takeTime;
			while (st.hasMoreTokens()) {
				int preBuild = Integer.parseInt(st.nextToken());
				
				if (preBuild == -1) break;
				
				list[preBuild].add(i);
				inDegree[i]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < n+1; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				dp[i] = time[i];
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int next : list[now]) {
				inDegree[next]--;
				dp[next] = Math.max(dp[next], dp[now] + time[next]);
				
				if (inDegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			System.out.println(dp[i]);
		}
	}
}
