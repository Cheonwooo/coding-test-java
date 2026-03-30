package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex15887 {
	
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		List<String> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int target = i + 1;
			int index = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] == target) {
					index = j;
					break;
				}
			}
			
			if (i != index) {
				reverse(i, index);
				answer.add((i + 1) + " " + (index + 1));
			}
		}
		System.out.println(answer.size());
		for (String text : answer) {
			System.out.println(text);
		}
	}

	private static void reverse(int x, int y) {
		while (x < y) {
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
			x++;
			y--;
		}
	}
}
