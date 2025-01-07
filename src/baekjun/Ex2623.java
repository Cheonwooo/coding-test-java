package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 15156kb, 시간 136ms

public class Ex2623 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] inDegree = new int[n+1];
		List<Integer>[] list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count-1; j++) {
				int next = Integer.parseInt(st.nextToken());
				
				list[start].add(next);
				inDegree[next]++;
				
				start = next;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < n+1; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		int count = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			
			sb.append(now + "\n");
			count++;
			
			for (int val : list[now]) {
				inDegree[val]--;
				
				if (inDegree[val] == 0) {
					q.offer(val);
				}
			}
		}
		
		if (count != n) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}

}
