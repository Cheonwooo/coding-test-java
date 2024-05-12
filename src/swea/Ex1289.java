package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1289 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			String[] numbers = br.readLine().split("");
			
			int count = 0;
			for (int i = 0; i < numbers.length-1; i++) {
				if (!numbers[i].equals(numbers[i+1])) {
					count++;
				}
			}
			
			if (numbers[0].equals("0")) {
				sb.append(count).append("\n");
			} else {
				count += 1;
				sb.append(count).append("\n");
			}
		}
		System.out.println(sb);
	}
}
