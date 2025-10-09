package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("");
		
		long[] arr = new long[4];
		for (int i = 0; i < n; i++) {
			if (input[i].equals("A")) {
				arr[0]++;
			} else if (input[i].equals("C")) {
				arr[1]++;
			} else if (input[i].equals("G")) {
				arr[2]++;
			} else if (input[i].equals("T")) {
				arr[3]++;
			}
		}
		
		long answer = 1;
		for (int i = 0; i < 4; i++) {
			answer = (answer*arr[i]) % 1_000_000_007;
		}
		System.out.println(answer);
	}

}
