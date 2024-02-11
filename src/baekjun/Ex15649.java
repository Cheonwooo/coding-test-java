package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 
 * 조합문제
 * 1부터 n까지 for문 돌고
 * 1부터 i를 제외하고 for문 한번 더 돌기 * m번 수행
 * 
 * 시간복잡도
 * n ^ m = 2^24
 * 
 * 자료구조
 * 입력값을 받을 두 int
 */

public class Ex15649 {
	private static int n, m;
	private static boolean[] check;
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new boolean[n];
		arr = new int[m];
		
		comb(0);
	}
	
	private static void comb(int depth) {
		if (depth == m) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[depth] = i + 1;
				comb(depth+1);
				check[i] = false;
			}
		}
	}

}
