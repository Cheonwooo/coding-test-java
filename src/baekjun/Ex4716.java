package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex4716 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (n == 0 && a == 0 && b == 0) break;
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
				return Math.abs(o2[1] - o2[2]) - Math.abs(o1[1] - o1[2]);
			}); 
				
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int count = Integer.parseInt(st.nextToken());
				int da = Integer.parseInt(st.nextToken());
				int db = Integer.parseInt(st.nextToken());
				
				pq.offer(new int[] {count, da, db});
			}
			int answer = 0;
			
			while (!pq.isEmpty()) {
				int[] next = pq.poll();
				
				//거리가 가까운 곳 부터
				if (next[1] < next[2]) {//A가 더 가깝다면
					//남은 갯수 확인
					if (next[0] <= a) {
						a -= next[0];
						answer += next[0] * next[1];
					} else {//a의 갯수가 모자르다면 b까지
						answer += next[1] * a;
						answer += (next[0] - a) * next[2];
						
						b -= (next[0] - a);
						a = 0;
					}
				} else {//B가 더 가깝다면
					//남은 갯수 확인
					if (next[0] <= b) {
						b -= next[0];
						answer += next[0] * next[2];
					} else {//b의 갯수가 모자르다면 a까지
						answer += next[2] * b;
						answer += (next[0] - b) * next[1];
						
						a -= (next[0] - b);
						b = 0;
					}
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}
