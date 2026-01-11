package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20207 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[366];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken());
			
			for (int j = start; j <= end; j++) {
				arr[j]++;
			}
		}
		
		int area = calculateArea(arr);
		System.out.println(area);
	}

	private static int calculateArea(int[] arr) {
		int height = 0;
		int width = 0;
		int area = 0;
		for (int i = 1; i <= 365; i++) {
			if (arr[i] == 0) {
				area += height * width;
				height = 0;
				width = 0;
			} else {
				height = Math.max(height, arr[i]);
				width++;
			}
			
			if (i == 365 && arr[i] != 0) {
				area += height * width;
			}
		}
		return area;
	}
}

/*
 * PQ 사용
 * 2 4 - 1
 * 4 5 - 2
 * 5 7 - 1
 * 5 6 - 3
 * 7 9 - 2
 * 11 12 - 1
 * 12 12 - 2
 * 이 셋을 어떻게 처리할까
 *
 * 먼저 List로 정렬해서 Q로 넣어서 q.isEmpty()가 될 때까지?
 * int[]로 카운트 하면서 0인 부분이 있으면 분기점
 * arr[2] ~ arr[9] >= 1임, arr[10] = 0 arr[11] ~ arr[12] >= 1
 * 0인 부분을 기점으로 최댓값이 높이, 2~9가 가로길이
 * 
 * 
 */
