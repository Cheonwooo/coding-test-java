package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 아이디어
 * 작업이 끝난 시간 보다 작거나 시간에서 
 * 요청된 디스크 중 작업 소요시간이 가장 작은 값을 순서대로 처리하기
 * 
 * 
 * 
 */

public class Ex42627 {
	public static void main(String[] args) {
		int[][] jobs = {{0,3}, {1,9}, {2,6}};
		
		System.out.println(solution(jobs));
	}
	
	public static int solution(int[][] jobs) {
		
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		int index = 0;
		int current = 0;
		int requestCount = 0;
		int answer = 0;
		
		while (requestCount < jobs.length) {
			while (index < jobs.length && jobs[index][0] <= current) {
				pq.add(jobs[index++]);
			}
			
			if (pq.isEmpty()) {
				current = jobs[index][0];
			} else {
				int[] temp = pq.poll();
				answer += temp[1] + current - temp[0];
				current += temp[1];
				requestCount++;
			}
		}
		
		return answer/requestCount;
	}

}
