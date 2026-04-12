package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex30645 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(height);
		
		int[] maxH = new int[c];
		int index = 0;
		int answer = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				while (index < n && height[index] <= maxH[j]) {
					index++;
				}
				if (index >= n) break;
				
				maxH[j] = height[index++];
				answer++;
			}
			if (index >= n) break;
		}
		
		System.out.println(answer);
	}

}
