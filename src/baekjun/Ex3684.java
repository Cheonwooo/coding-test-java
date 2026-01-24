package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex3684 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[201];
		for (int i = 1; i <= T; i++) {
			arr[2 * i - 1] = Integer.parseInt(br.readLine());
		}
		
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < 10_001; i++) {
			for (int j = 0; j < 10_001; j++) {
				int result = (arr[1] * i + j) % 10001;//arr[2]
					
				int next = ((result * i + j) % 10001);
				if (next == arr[3]) {
					q.add(new int[] {i, j, next});
				}
			}
		}
		
		for (int i = 4; i < T * 2 + 1; i++) {
			int size = q.size();
			
			for (int j = 0; j < size; j++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int next = cur[2];
				
				int result = (next * x  + y) % 10001;
				if (i % 2 == 0) {//값을 비교해서 저장할 때
					q.add(new int[] {x, y, result});
				} else {
					if (result == arr[i]) {
						q.add(new int[] {x, y, result});
					}
				}
			}
		}
		
		int[] cur = q.poll();
		int x = cur[0];
		int y = cur[1];
		
		for (int i = 1; i < T * 2 + 1; i += 2) {
			System.out.println((arr[i] * x + y) % 10001);
		}
	}
}
