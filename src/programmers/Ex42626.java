package programmers;

import java.util.PriorityQueue;

/*
 * ���̵��
 * pq �̿��ϱ�
 * 1. ���� ���� �� + (�ι�°�� ���� �� * 2)
 * 2. pq�� ���� ���� ���� K�� �Ѵ´ٸ� ��
 *  -> pq����� 1�̰� K���� ���� ���Ѵٸ� -1 ���
 *  
 * �ð����⵵
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
