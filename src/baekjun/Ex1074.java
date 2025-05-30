package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1074 {
	
	private static int count = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int len = (int)Math.pow(2, n);
		
		find(len, r, c);
		System.out.println(count);
	}
	
	private static void find(int len, int r, int c) {
		if (len == 1) {
			return;
		}
		
		if (r < len / 2 && c < len / 2) {
			find(len/2, r, c);
		} else if (r < len/2 && c >= len/2) {
			count += len * len / 4;
			find(len/2, r, c - len/2);
		} else if (r >= len/2 && c < len/2) {
			count += (len * len / 4) * 2;
			find(len/2, r - len/2, c);
		} else {
			count += (len * len / 4) * 3;
			find(len/2, r - len/2, c - len/2);
		}
	}
}