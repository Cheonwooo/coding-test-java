package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13300 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] students = new int[7][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			students[grade][gender]++;
		}
		
		int answer = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				answer += students[i][j] / k;
				students[i][j] %= k;
				if (students[i][j] != 0) {
					answer += 1;
				}
			}
		}
		System.out.println(answer);
	}

}
