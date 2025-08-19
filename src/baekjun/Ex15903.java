package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex15903 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> card = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			card.offer(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < m; i++) {
			long pre = card.poll();
			long next = card.poll();
			
			long sum = pre + next;
			card.offer(sum);
			card.offer(sum);
		}
		
		long sum = 0;
		while (!card.isEmpty()) { 
			sum += card.poll();
		}
		
		System.out.println(sum);
	}
}
