package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex32930 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<int[]> list = new ArrayList<>();
		
		int startX = 0;
		int startY = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {x, y, (startX-x)*(startX-x) + (startY-y)*(startY-y)});
		}
		
		int answer = 0;
		for (int i = 0; i < m; i++) {
			Collections.sort(list, (o1, o2) -> o2[2] - o1[2]);
			
			int[] now = list.get(0);
			startX = now[0];
			startY = now[1];
			answer += now[2];
			list.remove(0);
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int size = list.size();
			for (int j = 0; j < size; j++) {
				now = list.get(0);
				int nx = now[0];
				int ny = now[1];
				list.remove(0);
				list.add(new int[] {nx, ny, (startX-nx)*(startX-nx) + (startY-ny)*(startY-ny)});
			}
			list.add(new int[] {x, y, (startX-x)*(startX-x) + (startY-y)*(startY-y)});
		}
		System.out.println(answer);
	}

}
