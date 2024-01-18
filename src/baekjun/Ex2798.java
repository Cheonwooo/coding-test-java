package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : n개중 3개를 뽑아 최대값을 구하기
 * 조합 이용하기
 * 
 * 시간복잡도 : nC3 = (100 * 99 * 98) / (3 * 2 * 1)
 * 
 * 자료구조 : List
 */

public class Ex2798 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] cards = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cards.length-2; i++) {
			for (int j = i+1; j < cards.length-1; j++) {
				for (int k = j+1; k < cards.length; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					
					if (sum <= m && sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}

}
