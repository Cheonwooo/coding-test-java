package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex17615 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] balls = br.readLine().toCharArray();
		
		int answer = Integer.MAX_VALUE;
		
		//LR
		int count = 0;
		boolean check = false;
		for (int i = 0; i < n; i++) {
			if(balls[i] == 'R') check = true;
			
			if (check && balls[i] == 'B') {
				count++;
			}
		}
		answer = Math.min(answer, count);
		
		//LB
		count = 0;
		check = false;
		for (int i = 0; i < n; i++) {
			if(balls[i] == 'B') check = true;
			
			if (check && balls[i] == 'R') {
				count++;
			}
		}
		answer = Math.min(answer, count);
		
		//RR
		count = 0;
		check = false;
		for (int i = n-1; i >= 0; i--) {
			if(balls[i] == 'R') check = true;
			
			if (check && balls[i] == 'B') {
				count++;
			}
		}
		answer = Math.min(answer, count);
		
		//RB
		count = 0;
		check = false;
		for (int i = n-1; i >= 0; i--) {
			if(balls[i] == 'B') check = true;
			
			if (check && balls[i] == 'R') {
				count++;
			}
		}
		answer = Math.min(answer, count);
		
		System.out.println(answer);
	}
}
