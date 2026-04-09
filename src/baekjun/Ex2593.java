package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex2593 {
	
	private static int[] d, usedElevator, parentFloor;
	private static boolean[] visited;
	private static List<Integer>[] eNum, floor;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		eNum = new List[m+1];//엘베번호에 속한 층
		floor = new List[n+1];//층이 속한 엘베 번호
		
		for (int i = 0; i < m+1; i++) {
			eNum[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n+1; i++) {
			floor[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j <= n; j += y) {
				eNum[i+1].add(j);
				floor[j].add(i+1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		d = new int[n+1];
		usedElevator = new int[n+1];
		parentFloor = new int[n+1];
		visited = new boolean[m+1];
		
		Arrays.fill(d, -1);
		
		bfs(a, b);
		
		if (d[b] == -1) {
			System.out.println(-1);
		} else {
			System.out.println(d[b]);
			Stack<Integer> route = new Stack<>();
			int cur = b;
			while (cur != a) {
				route.push(usedElevator[cur]);
				cur = parentFloor[cur];
			}
			
			while (!route.isEmpty()) {
				System.out.println(route.pop());
			}
		}
	}
	
	private static void bfs(int a, int b) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(a);
		d[a] = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (cur == b) break;
			
			for (int num : floor[cur]) {
				if (visited[num]) continue;
				visited[num] = true;
				
				for (int nextFloor : eNum[num]) {
					if (d[nextFloor] == -1) {
						d[nextFloor] = d[cur] + 1;
						parentFloor[nextFloor] = cur;
						usedElevator[nextFloor] = num;
						q.offer(nextFloor);
					}
				}
			}
		}
	}
}
