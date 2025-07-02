package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex27172 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] selected = new int[1_000_001];
		int[] answer = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			selected[arr[i]] = i+1;
		}
		
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			
			for (int j = num * 2; j < 1_000_001; j+=num) {
				if (selected[j] > 0) {
					answer[selected[j]]--;
					answer[selected[num]]++;
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
	}

}
/*
 * 3 = 1 3
 * 4 = 1 4
 * 12 = 1 2 3 4 6 12
 * Map count
 * 1 - 3
 * 2 - 1
 * 3 - 2
 * 4 - 2
 * 6 - 1
 * 12 - 1
 */