package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//메모리 76972kb, 시간 996ms

public class Ex1781 {
	
	private static class Noodle implements Comparable<Noodle> {
		int deadLine;
		int count;

		public Noodle(int deadLine, int count) {
			this.deadLine = deadLine;
			this.count = count;
		}
		
		public int compareTo(Noodle o) {
			if (this.deadLine == o.deadLine) {
				return o.count - this.count;
			}
			return this.deadLine - o.deadLine;
		}

		@Override
		public String toString() {
			return "Noodle [deadLine=" + deadLine + ", count=" + count + "]";
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		Noodle[] noodles = new Noodle[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int deadLine = Integer.parseInt(st.nextToken());
			int noodleCount = Integer.parseInt(st.nextToken());
			noodles[i] = new Noodle(deadLine, noodleCount);
		}
		
		Arrays.sort(noodles);
		
		int deadLine = 0;
		long sum = 0;
		for (Noodle noodle : noodles) {
			int size = pq.size();
			
			if (size < noodle.deadLine) {
				pq.offer(noodle.count);
			} else if (size == noodle.deadLine) {
				int peek = pq.peek();
				System.out.println(peek);
				
				if (peek < noodle.count) {
					pq.poll();
					pq.add(noodle.count);
				}
			}
		}
		
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}

}
