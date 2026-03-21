package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex10981 {
	
	private static class Team implements Comparable<Team> {
		String univ;
		String team;
		int count;
		int penalty;
		
		public Team(String univ, String team, int count, int penalty) {
			this.univ = univ;
			this.team = team;
			this.count = count;
			this.penalty = penalty;
		}

		public int compareTo(Team o) {
			if (this.count == o.count) {
				return this.penalty - o.penalty;
			}
			return o.count - this.count;
		}
	}
	
	private static int index;
	private static PriorityQueue<Team> pq = new PriorityQueue<>();
	private static Map<String, Boolean> visited = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			
			String univ = input[0];
			String team = input[1];
			int solvedCount = Integer.parseInt(input[2]);
			int penalty = Integer.parseInt(input[3]);
			
			pq.offer(new Team(univ, team, solvedCount, penalty));
		}
		
		while (k > 0) {
			Team finalTeam = pq.poll();
			if (visited.get(finalTeam.univ) == null) {
				visited.put(finalTeam.univ, true);
				System.out.println(finalTeam.team);
				k--;
			}
		}
	}

}
