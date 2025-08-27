package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex27522 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0] && o1[1] == o2[1]) {
				return o1[2] - o2[2];
			} else if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		
		String[] teams = new String[8];
		for (int i = 0; i < 8; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String[] times = st.nextToken().split(":");
			String team = st.nextToken();
			teams[i] = team;
			
			pq.offer(new int[] {Integer.parseInt(times[0]), 
					Integer.parseInt(times[1]),
					Integer.parseInt(times[2]), i});		
		}
		
		int[] score = {10, 8, 6, 5, 4, 3, 2, 1};
		int[] answer = new int[2];
		int index = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (teams[now[3]].equals("B")) {
				answer[0] += score[index++];
			} else {
				answer[1] += score[index++];
			}
		}
		
		System.out.println((answer[0] > answer[1]) ? "Blue" : "Red");
	}
}
