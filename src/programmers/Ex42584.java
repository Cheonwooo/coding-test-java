package programmers;

import java.util.PriorityQueue;

/*
 * 아이디어
 * for문 돌면서 낮은 숫자가 나올 때까지 count++
 * 
 * 시간복잡도
 * n*(n-1)/2
 * 
 */

public class Ex42584 {
	
	public static class Price implements Comparable<Price>{
		int value;
		int index;
		
		public Price(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		public int compareTo(Price other) {
			return this.value - other.value;
		}
	}


	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		
		int[] arr = solution(prices);
		
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
	
	public static int[] solution(int[] prices) {
		PriorityQueue<Price> pq = new PriorityQueue<>();
		
		for (int i = 0; i < prices.length; i++) {
			pq.offer(new Price(prices[i], i));
		}
	}

}
