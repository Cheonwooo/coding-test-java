package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10211 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {//시작위치
				//시작위치로 부터의 갯수
				for (int j = 1; j < n - i + 1; j++) {
					int sum = 0;
					//인덱스 2면 최대 2개 더
					for (int k = 0; k < j; k++) {
						sum += arr[i+k];
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println(max);
		}
	}

}

