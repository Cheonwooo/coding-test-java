package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 49972kb, 시간 736ms

public class Ex1766 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] inDegree = new int[n+1];
		
		List<Integer>[] list = new List[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			list[pre].add(next);
			inDegree[next]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < n+1; i++) {
			if (inDegree[i] == 0) {
				pq.offer(i);
			}
		}
		
		while (!pq.isEmpty()) {
			int now = pq.poll();
			
			System.out.print(now + " ");
			
			for (int val : list[now]) {
				inDegree[val]--;
				
				if (inDegree[val] == 0) {
					pq.offer(val);
				}
			}
		}
	}

}

/*
 * 4 5
 * 4 2
 * 4 3
 * 3 2
 * 3 1
 * 2 1
 * 
 * -> 4 3 2 1
 */
 
