package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10833 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int studentNumber = Integer.parseInt(st.nextToken());
			int appleNumber = Integer.parseInt(st.nextToken());
			
			int quo = appleNumber / studentNumber;
			if (quo == 0) {
				answer += appleNumber % studentNumber;
			} else {
				answer += appleNumber % (studentNumber * quo);
			}
		}
		System.out.println(answer);
	}

}
