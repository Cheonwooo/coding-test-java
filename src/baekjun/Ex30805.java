package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Ex30805 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) { 
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o2[0], o1[0]);
		});
		
		int n = Integer.parseInt(br.readLine());
		int[] arrA = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {arrA[i], i});
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] arrB = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		String answer = "";
		int start = 0;
		int index = -1;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (index > cur[1]) continue;
			
			for (int i = start; i < m; i++) {
				if (arrB[i] == cur[0]) {
					count++;
					start = i+1;
					index = cur[1];
					answer += String.valueOf(cur[0]) + " ";
					break;
				}
			}
		}
		System.out.println(count);
		System.out.println(answer);
	}
}
