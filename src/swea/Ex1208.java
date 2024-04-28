package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1208 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			int[] dumps = new int[100];
			
			int dumpCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				dumps[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			answer = calculateGap(dumps, dumpCount);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int calculateGap(int[] dumps, int dumpCount) {
		while (dumpCount != 0) {
			dumpCount--;
			
			Arrays.sort(dumps);
			
			if (dumps[99] - dumps[0] <= 1) {
				break;
			}
			
			dumps[0]++;
			dumps[99]--;
		}
		
		Arrays.sort(dumps);
		
		return dumps[99] - dumps[0];
	}

}
