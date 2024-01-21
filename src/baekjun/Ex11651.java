package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 아이디어 : Arrays.sort()를 이용하기, 람다식 이용
 * 
 * 시간복잡도 : nlogn
 * 
 * 자료구조 : int[][]
 */

public class Ex11651 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}
