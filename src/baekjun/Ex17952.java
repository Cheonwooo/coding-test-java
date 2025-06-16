package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex17952 {
	
	private static class Course implements Comparable<Course>{
		int time;
		int score;
		int rest;

		public Course(int time, int score, int rest) {
			this.time = time;
			this.score = score;
			this.rest = rest;
		}
		
		public int compareTo(Course other) {
			return other.time - this.time;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Course> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int i = 0; i < n; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int option = Integer.parseInt(st.nextToken());
			
			if (option == 1) {
				int a = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				pq.offer(new Course(i, a, t));
			}
			
			if (!pq.isEmpty()) {
				Course now = pq.poll();
				
				int nowTime = now.time;
				int nowScore = now.score;
				int nowRest = now.rest;
				
				if ((nowRest-1) == 0) {
					answer += nowScore;
				} else {
					pq.offer(new Course(nowTime, nowScore, nowRest-1));
				}
			}
		}
		System.out.println(answer);
		
	}
}
