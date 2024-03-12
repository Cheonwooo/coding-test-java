package programmers;

import java.util.PriorityQueue;

/*
 * 아이디어
 * pq 이용하기
 * 1. 제일 작은 값 + (두번째로 작은 값 * 2)
 * 2. pq의 제일 작은 값이 K를 넘는다면 끝
 *  -> pq사이즈가 1이고 K값을 넘지 못한다면 -1 출력
 *  
 * 시간복잡도
 * n-1
 */

public class Ex42626 {

	public static void main(String[] args) {
		int[] scoville = {1,1,2,3,4,5};
		int k = 7;
		
		System.out.println(solution(scoville, k));
	}
	
	public static int solution(int[] scoville, int k) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for (int i = 0; i < scoville.length; i++) {
			pq.offer((long)scoville[i]);
		}
		
		int count = 0;
		while (true) {
			long first = pq.poll();
			
			if (first >= k) {
				break;
			}
			
			if (pq.size() == 0 && first < k) {
				count = -1;
				break;
			}
			
			long second = pq.poll();
			long newScoville = first + (second * 2);
			count++;
			
			pq.offer(newScoville);
		}
		
		return count;
	}

}
