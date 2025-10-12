package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex1021 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		
		LinkedList<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			dq.offer(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int i = 0; i < m; i++) {
			int idx = dq.indexOf(arr[i]);
			
			int mid = 0;
			
			if (dq.size() % 2 == 0) {
				mid = dq.size() / 2 - 1;
			} else {
				mid = dq.size() / 2;
			}
			
			if (idx <= mid) {
				for (int j = 0; j < idx; j++) {
					int temp = dq.pollFirst();
					dq.offerLast(temp);
					count++;
				}
			} else {
				for (int j = 0; j < dq.size() - idx; j++) {
					int temp = dq.pollLast();
					dq.offerFirst(temp);
					count++;
				}
			}
			dq.pollFirst();
		}
		System.out.println(count);
		
	}

}
