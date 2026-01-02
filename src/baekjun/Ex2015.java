package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex2015 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> count = new HashMap<>();
		count.put(0, 1);
		
		long answer = 0;
		for (int i = 1; i <= n; i++) {
			answer += count.getOrDefault(sum[i] - k, 0);
			count.put(sum[i], count.getOrDefault(sum[i], 0) + 1);
		}
		System.out.println(answer);
	}

}

/*
 * 슬라이딩 윈도우?
 * -> left부터 right까지의 합이 k보다 클 경우 left + 1을 할 수 있지만 
 * arr의 값이 음수도 있기 때문에 반례가 생길 수 있음.
 * 세그먼트 트리?
 * -> 모든 부분합을 구하는거라 애매함
 */
