package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 15660kb, 시간 120ms

public class Ex2629 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] weights = new int[n];
		boolean[] check = new boolean[40001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int weight = Integer.parseInt(st.nextToken());
		weights[0] = weight; 
		check[weight] = true;
		for (int i = 1; i < n; i++) {
			weight = Integer.parseInt(st.nextToken());
			boolean[] tempCheck = new boolean[40001];
			for (int j = 0; j < 40001; j++) {
				if (check[j]) {
					tempCheck[j] = true;
					tempCheck[weight] = true;
					tempCheck[Math.abs(weight-j)] = true;
					tempCheck[weight+j] = true;
				}
			}
			check = tempCheck;
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			if (check[Integer.parseInt(st.nextToken())]) {
				System.out.print("Y ");
			} else {
				System.out.print("N ");
			}
		}
	}
}
