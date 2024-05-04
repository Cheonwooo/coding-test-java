package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1225 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append("#" + n + " ");
			
			Queue<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			while (true) {
				boolean check = false;
				
				for (int j = 1; j <= 5; j++) {
					int number = q.poll() - j;
					
					if (number <= 0) {
						number = 0;
						q.offer(number);
						check = true;
						break;
					} else {
						q.offer(number);
					}
				}
				
				if (check) break;
			}
			
			while (!q.isEmpty()) {
				sb.append(q.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
