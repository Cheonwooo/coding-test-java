package programmers;

import java.util.PriorityQueue;

/*
 * ���̵��
 * for�� ���鼭 ���� ���ڰ� ���� ������ count++
 * 
 * �ð����⵵
 * n*(n-1)/2
 * 
 */

public class Ex42584 {
	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		
		int[] arr = solution(prices);
		
		for (int val : arr) {
			System.out.print(val + " ");
		}
		
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for (int i = 0; i < prices.length; i++) {
			
			for (int j = i+1; j < prices.length; j++) {
				answer[i]++;
                if (prices[i] > prices[j]) break;
            }
		}
		
		return answer;
	}

}
