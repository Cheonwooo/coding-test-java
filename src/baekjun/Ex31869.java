package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex31869 {
	private static class Schedule implements Comparable<Schedule> {
		String name;
		int day;
		int money;

		public Schedule(String name, int day, int money) {
			this.name = name;
			this.day = day;
			this.money = money;
		}
		
		public int compareTo(Schedule o) { 
			return this.day - o.day;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Schedule> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int week = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken()) + 1;
			int money = Integer.parseInt(st.nextToken());
			
			//week * 7 + day로 저장
			pq.offer(new Schedule(name, week*7 + day, money));
		}
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int money = Integer.parseInt(st.nextToken());
			map.put(name, money);
		}
		
		boolean[] check = new boolean[101];
		while (!pq.isEmpty()) {
			Schedule now = pq.poll();
			
			String name = now.name;
			int day = now.day;
			int money = now.money;
			
			int myMoney = map.get(name);
			
			if (myMoney >= money) {
				check[day] = true;
			}
		}
		
		int max = Integer.MIN_VALUE;
		int count = 0;
		
		for (int i = 0; i < 100; i++) {
			if (check[i] && check[i+1]) {
				count++;
			} else if ((check[i] && !check[i+1]) || (!check[i] && check[i+1])) {
				count = 1;
			}
			max = Math.max(count, max);
		}
		System.out.println(max);
	}

}
