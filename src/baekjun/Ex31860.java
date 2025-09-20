package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex31860 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		List<Integer> answer = new ArrayList<>();
		int pre = 0;
		while (!pq.isEmpty()) {
			int imp = pq.poll();

			answer.add((pre/2) + imp);
			
			if (imp - m > k) {
				pq.offer(imp - m);
			}
			pre = (pre/2) + imp;
		}
		
		System.out.println(answer.size());
		for (int num : answer) {
			sb.append(num + "\n");
		}
		System.out.println(sb);
	}

}
