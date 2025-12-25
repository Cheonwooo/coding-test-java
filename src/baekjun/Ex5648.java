package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex5648 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input;
		while ((input = br.readLine()) != null) {
			sb.append(input).append(" ");
		}
		
		StringTokenizer st = new StringTokenizer(sb.toString());
		int n = Integer.parseInt(st.nextToken());
		
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			answer[i] = Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString());
		}
		
		Arrays.sort(answer);
		
		sb = new StringBuilder();
		for (long num : answer) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
}
