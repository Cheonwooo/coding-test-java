package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex14235 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (pq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				for (int j = 0; j < a; j++) {
					int price = Integer.parseInt(st.nextToken());
					pq.offer(price);
				}
			}
		}
	}

}
