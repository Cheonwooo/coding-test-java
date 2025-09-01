package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19949 {
	
	private static int answer;
	private static int[] arr, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[10];
		
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		temp = new int[10];
		comb(0);
		
		System.out.println(answer);
	}
	
	private static void comb(int depth) {
		if (depth == 10) {
			int count = 0;
			for (int i = 0; i < 10; i++) {
				
				if (arr[i] == temp[i]) count++;
			}
			if (count >= 5) {
				answer++;
			}
			return;
		}
		
		for (int i = 1; i <= 5; i++) {
			if (depth >= 2) {
				if (temp[depth - 2] == i && temp[depth - 1] == i) continue;
			}
			temp[depth] = i;
			comb(depth + 1);
		}
	}
}
