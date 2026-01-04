package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2777 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int number = Integer.parseInt(br.readLine());
			
			if (number == 1) {
				sb.append(1 + "\n");
				continue;
			}
			
			int index = 9;
			int answer = 0;
			
			while (index > 1) {
				if (number % index == 0) {
					number /= index;
					answer += 1;
				} else {
					index--;
				}
			}
			
			if (number != 1) {
				sb.append(-1 + "\n");
			} else {
				sb.append(answer + "\n");
			}
		}
		System.out.println(sb);
	}

}
