package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 563820kb, 시간 1064ms

public class Ex20303 {
	
	public static class Friend implements Comparable<Friend>{
		int sum;
		List<Integer> friends;

		public Friend(int sum, List<Integer> friends) {
			this.sum = sum;
			this.friends = friends;
		}

		public int compareTo(Friend o) {
			return o.sum - this.sum;
		}
		
		@Override
		public String toString() {
			return "Friend [sum=" + sum + ", friends=" + friends + "]";
		}
	}
	
	private static int n, m, k;
	private static int[] candy, totalCandy;
	private static boolean[] visited;
	private static List<Integer>[] list;
	private static List<Friend> total; 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		candy = new int[n+1];
		totalCandy = new int[n+1];
		list = new List[n+1];
		total = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int to = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			list[to].add(next);
			list[next].add(to);
		}
		
		visited = new boolean[n+1];
		for (int i = 1; i < n+1; i++) {
			if (!visited[i]) countFriends(i);			
		}
		
		int dp[][] = new int[total.size()+1][k];
		for (int i = 0; i < total.size() + 1; i++) {
			for (int j = 0; j < k; j++) {
				if (i == 0 || j == 0) dp[i][j] = 0;
				else if (total.get(i-1).friends.size() <= j) {
					dp[i][j] = Math.max(total.get(i-1).sum + dp[i-1][j-total.get(i-1).friends.size()], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[total.size()][k-1]);
	}

	public static void countFriends(int start) {
		Queue<Integer> q = new LinkedList<>();
		int count = 1;
		int sum = candy[start];
		List<Integer> friends = new ArrayList<>();
		
		visited[start] = true;
		q.add(start);
		friends.add(start);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i <list[now].size(); i++) {
				int next = list[now].get(i);
				if (!visited[next]) {
					visited[next] = true;
					count++;
					sum += candy[next];
					friends.add(next);
					q.add(next);
				}
			}
		}
		totalCandy[start] = sum;
		total.add(new Friend(totalCandy[start], friends));
	}
}
