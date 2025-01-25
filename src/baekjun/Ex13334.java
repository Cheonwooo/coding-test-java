package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 48840kb, 시간 584ms

public class Ex13334 {
	
	private static class Pair implements Comparable<Pair>{ 
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = Math.min(start, end);
			this.end = Math.max(start, end);
		}
		
		public int compareTo(Pair o) {
			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			int h = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			list.add(new Pair(h, o));
		}

		int d = Integer.parseInt(br.readLine());
		
		Collections.sort(list);
		
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Pair pair : list) {
			while (!pq.isEmpty() && pq.peek() < pair.end - d) {
				pq.poll();
			}
			
			if (pair.start >= pair.end - d) {
				pq.offer(pair.start);
			}
			
			answer = Math.max(answer, pq.size());
		}
		System.out.println(answer);
	}

}
