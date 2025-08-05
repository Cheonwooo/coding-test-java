package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex3758 {
	
	private static class Team implements Comparable<Team> {
		int teamId;
		int score;
		int count;
		int time;

		public Team(int teamId, int score, int count, int time) {
			this.teamId = teamId;
			this.score = score;
			this.count = count;
			this.time = time;
		}
		
		public int compareTo(Team o) {
			if (this.score == o.score && this.count == o.count) {
				return this.time - o.time;
			} else if (this.score == o.score) {
				return this.count - o.count;
			}
			return o.score - this.score;
		}

		@Override
		public String toString() {
			return "Team [teamId=" + teamId + ", score=" + score + ", count=" + count + ", time=" + time + "]";
		}
	}

	private static Team[] teams;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] problemMaxScore = new int[n+1][k+1];
			
			teams = new Team[n+1];
			for (int i = 0; i < n+1; i++) {
				teams[i] = new Team(i, 0, 0, 100001);
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int teamId = Integer.parseInt(st.nextToken());
				int proNum = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				problemMaxScore[teamId][proNum] = Math.max(s, problemMaxScore[teamId][proNum]);
				teams[teamId].count++;
				teams[teamId].time = i;
			}
			
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < k+1; j++) {
					teams[i].score += problemMaxScore[i][j];
				}
			}
			
			Arrays.sort(teams);
			for (int i = 0; i < n+1; i++) {
//				System.out.println(teams[i]);
				if (teams[i].teamId == id) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}
