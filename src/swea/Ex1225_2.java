package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1225_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int T = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int subIndex = 1;
			while (true) {
				if (subIndex > 5) subIndex = 1;
				int num = q.poll();
				num -= subIndex++;
				
				if (num <= 0) {
					num = 0;
					q.add(num);
					break;
				} 
				q.add(num);
			}
			
			while (!q.isEmpty()) {
				sb.append(q.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
