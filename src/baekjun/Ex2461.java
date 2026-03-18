package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2461 {
	
	private static int n, m;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

		int answer = Integer.MAX_VALUE;
		int max = -1;
		int min = 1_000_000_001;
		list = new List[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
			
			st=  new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
			
			
			Collections.sort(list[i]);
			max = Math.max(max, list[i].get(0));
			min = Math.min(min, list[i].get(0));
			pq.offer(new int[] {list[i].get(0), i});
		}
		
		int[] index = new int[n];
		while (true) {
			if (max - min < answer) {
				answer = max - min;
			}
			
			int[] next = pq.poll();
			int changeIndex = next[1];
			index[changeIndex]++;
			
			if (index[changeIndex] == m) break;
			
			pq.offer(new int[] {list[changeIndex].get(index[changeIndex]), changeIndex});
			max = Math.max(max, list[changeIndex].get(index[changeIndex]));
			min = pq.peek()[0];
		}
		
		System.out.println(answer);
	}
}
