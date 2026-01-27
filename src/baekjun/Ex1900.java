package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1900 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] players = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			players[i][0] = Integer.parseInt(st.nextToken());
			players[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] winCount = new int[n];
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (i == j) continue;
				int scoreA = players[i][0] + players[i][1] * players[j][0];
				int scoreB = players[j][0] + players[j][1] * players[i][0];
				
				if (scoreA > scoreB) winCount[i]++;
				else winCount[j]++;
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		for (int i = 0; i < n; i++) {
			pq.offer(new int[] {i+1, winCount[i]});
		}
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			
			System.out.println(now[0]);
		}
	}

}
