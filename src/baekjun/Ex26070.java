package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex26070 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		count[0] = Integer.parseInt(st.nextToken());
		count[1] = Integer.parseInt(st.nextToken());
		count[2] = Integer.parseInt(st.nextToken());
		
		long[] tickets = new long[3];
		st = new StringTokenizer(br.readLine());
		tickets[0] = Long.parseLong(st.nextToken());
		tickets[1] = Long.parseLong(st.nextToken());
		tickets[2] = Long.parseLong(st.nextToken());
		
		long answer = 0;
		for (int i = 0; i < 3; i++) {
			if (count[i] <= tickets[i]) {
				answer += count[i];
				tickets[i] -= count[i];
				count[i] = 0;
			} else {
				answer += tickets[i];
				count[i] -= tickets[i];
				tickets[i] = 0;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if (tickets[i % 3] > 0) {
				tickets[(i+1) % 3] += tickets[i % 3] / 3;
				tickets[i % 3] %= 3;
			}
			
			if (count[(i+1) % 3] <= tickets[(i+1) % 3]) {
				answer += count[(i+1) % 3];
				tickets[(i+1) % 3] -= count[(i+1) % 3];
				count[(i+1) % 3] = 0;
			} else {
				answer += tickets[(i+1) % 3];
				count[(i+1) % 3] -= tickets[(i+1) % 3];
				tickets[(i+1) % 3] = 0;
			}
		}
		System.out.println(answer);
	}

}
